import pandas as pd
from flask import Flask, request, jsonify, render_template
from flask_cors import CORS
import pickle
from sklearn.ensemble import RandomForestClassifier
import LogisticRegression
import RandomForestModel
import NaiveBayes
from RandomForestModel import data as RandomForest_Data

# Create flask app
flask_app = Flask(__name__)
CORS(flask_app)
LR_model = pickle.load(open("LogisticRegressionModel.pkl", "rb"))
RF_Model = pickle.load(open("RandomForestModel.pkl", "rb"))
NB_Model = pickle.load(open("NaiveBayes.pkl", "rb"))

num_cols = ['ssc', 'hsc', 'quantitative_ability', 'logical_reasoning', 'english_proficiency', 'automata_score',
            'computer_science_score', 'internships', 'backlogs', 'projects', 'cgpa']

@flask_app.route("/")
def Home():
    return render_template("index.html")


@flask_app.route("/api/predict/lr", methods=["POST"])
def predict_lr():
    # print(request.json)
    input_data_json = request.json
    query_df = pd.DataFrame(input_data_json)
    query_df[num_cols] = LogisticRegression.scaler.transform(query_df[num_cols])
    prediction = LR_model.predict_proba(query_df[LogisticRegression.selected_features])
    # Create a dictionary to store the predicted probabilities for each Placed Sector category
    output = []
    for i in range(len(prediction)):
        row_dict = {}
        for j, category in enumerate(LogisticRegression.clf.classes_):
            row_dict[category] = prediction[i][j]
        output.append(row_dict)
    print(output)
    return jsonify(output)


@flask_app.route("/api/predict/rf", methods=["POST"])
def predict_rf():
    # print(request.json)
    input_data_json = request.json
    query_df = pd.DataFrame(input_data_json)
    query_df[num_cols] = RandomForestModel.scaler.transform(query_df[num_cols])
    prediction = RF_Model.predict_proba(query_df[RandomForestModel.selected_feat])
    output = []
    for i in range(len(prediction)):
        row_dict = {}
        for j, category in enumerate(RandomForestModel.clf.classes_):
            row_dict[category] = prediction[i][j]
        output.append(row_dict)
    # print(output)
    return jsonify(output)


@flask_app.route("/api/predict/nb", methods=["POST"])
def predict_nb():
    # print(request.json)
    input_data_json = request.json
    query_df = pd.DataFrame(input_data_json)
    query_df[num_cols] = NaiveBayes.scaler.transform(query_df[num_cols])
    prediction = NB_Model.predict_proba(query_df[NaiveBayes.selected_features])
    output = []
    for i in range(len(prediction)):
        row_dict = {}
        for j, category in enumerate(RandomForestModel.clf.classes_):
            row_dict[category] = prediction[i][j]
        output.append(row_dict)
    # print(output)
    return jsonify(output)


@flask_app.route("/api/impfeaturesRF", methods=["GET"])
def imp_features_rf():
    placed_sectors = ['Service', 'Product', 'FinTech', 'Startup']
    # Iterate over each Placed Sector
    imp_features = {}
    for sector in placed_sectors:
        print(f'Feature importances for {sector} sector:')
        # Split the data into features and target
        X = RandomForest_Data.drop('placed_sector', axis=1)
        y = (RandomForest_Data['placed_sector'] == sector).astype(int)  # Create binary target for the current sector

        # Train a Random Forest classifier
        rf = RandomForestClassifier()
        rf.fit(X, y)

        # Get the feature importances
        importances = pd.Series(rf.feature_importances_, index=X.columns)

        # Sort the importances in descending order
        importances_sorted = importances.sort_values(ascending=False)

        # Print the feature importances
        print(importances_sorted.to_dict())
        imp_features[sector] = importances_sorted.to_dict()
    print(imp_features)
    return jsonify(imp_features)


if __name__ == "__main__":
    flask_app.run(debug=True)

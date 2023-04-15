# Step 1: Data Preparation
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from sklearn.feature_selection import SelectFromModel
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
import pickle

# Load the dataset
data = pd.read_csv('data.csv')

data = data.fillna(0)

data = data.drop(['id','email'],axis=1)

features_to_split = ['branch']
for feature in features_to_split:
    dummy = pd.get_dummies(data[feature])
    data = pd.concat([data, dummy], axis=1)
    data.drop(feature, axis=1, inplace=True)

# Normalize the numerical features
scaler = MinMaxScaler()
num_cols = ['ssc', 'hsc', 'quantitative_ability', 'logical_reasoning', 'english_proficiency', 'automata_score', 'computer_science_score', 'internships', 'backlogs', 'projects', 'cgpa']
data[num_cols] = scaler.fit_transform(data[num_cols])

# Step 2: Feature Selection
X = data.drop('placed_sector', axis=1)
y = data['placed_sector']

# Use Random Forest for feature selection
sel = SelectFromModel(RandomForestClassifier(n_estimators=100, random_state=42), max_features=5)
sel.fit(X, y)

# Print the selected features
selected_feat= X.columns[(sel.get_support())]
print('Selected Features:', selected_feat)

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X[selected_feat], y, test_size=0.2, random_state=42)

# Step 3: Model Training
from sklearn.ensemble import RandomForestClassifier
clf = RandomForestClassifier(n_estimators=100, random_state=42)
clf.fit(X_train, y_train)

pickle.dump(clf,open("RandomForestModel.pkl", "wb"))
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from sklearn.feature_selection import RFE
import pickle

# Step 1: Data Preparation
# Load the dataset
data = pd.read_csv('data.csv')

data.head()

data = data.fillna(0)

data = data.drop(['id','email'],axis=1)

features_to_split = ['branch']
for feature in features_to_split:
    dummy = pd.get_dummies(data[feature])
    data = pd.concat([data, dummy], axis=1)
    data.drop(feature, axis=1, inplace=True)

data.head()

# Normalize the numerical features
scaler = MinMaxScaler()
num_cols = ['ssc', 'hsc', 'quantitative_ability', 'logical_reasoning', 'english_proficiency', 'automata_score', 'computer_science_score', 'internships', 'backlogs', 'projects', 'cgpa']
data[num_cols] = scaler.fit_transform(data[num_cols])


# Step 3: Model Selection
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score

# Split the data into training and testing sets
X = data.drop('placed_sector', axis=1)
y = data['placed_sector']

# Use Logistic Regression as the classification algorithm
clf = LogisticRegression()

# Create the RFE model and select the top 5 features
rfe = RFE(estimator=clf, n_features_to_select=5, step=1)
rfe.fit(X, y)

X_new = rfe.transform(X)  # Select only the selected features
selected_features = X.columns[rfe.get_support(indices=True)]  # Get the names of the selected features
print("Selected features:", selected_features)

X_train, X_test, y_train, y_test = train_test_split(X_new, y, test_size=0.2, random_state=42)

# Step 4: Model Training
# clf.fit(X_train, y_train)
clf.fit(X_train,y_train)

pickle.dump(clf,open("LogisticRegressionModel.pkl", "wb"))

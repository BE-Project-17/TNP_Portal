import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from sklearn.naive_bayes import GaussianNB
from sklearn.feature_selection import SelectKBest, chi2
import pickle

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

"""Normalize the numerical features"""

scaler = MinMaxScaler()
num_cols = ['ssc', 'hsc', 'quantitative_ability', 'logical_reasoning', 'english_proficiency', 'automata_score', 'computer_science_score', 'internships', 'backlogs', 'projects', 'cgpa']
data[num_cols] = scaler.fit_transform(data[num_cols])

data.head()

"""Select the K best features"""

X = data.drop('placed_sector', axis=1)
y = data['placed_sector']

selector = SelectKBest(chi2, k=5)
selector.fit(X, y)

X_new = selector.transform(X)
selected_features = X.columns[selector.get_support(indices=True)]
print("Selected features:", selected_features)

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X_new, y, test_size=0.2, random_state=42)

clf = GaussianNB()
clf.fit(X_train,y_train)

pickle.dump(clf,open("NaiveBayes.pkl", "wb"))
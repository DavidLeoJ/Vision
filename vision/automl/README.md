# AutoML Sample

<a href="https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/GoogleCloudPlatform/java-docs-samples&page=editor&open_in_editor=vision/beta/cloud-client/README.md">
<img alt="Open in Cloud Shell" src ="http://gstatic.com/cloudssh/images/open-btn.png"></a>

[Google Cloud AutoML Vision API][vision] provides feature detection for images.

This API is part of the larger collection of Cloud Machine Learning APIs.

This sample Java application demonstrates how to access the Cloud Vision API
using the [Google Cloud Client Library for Java][google-cloud-java].


[vision]: https://cloud.google.com/vision/automl/docs/
[google-cloud-java]: https://github.com/GoogleCloudPlatform/google-cloud-java

## Set the environment variables

GOOGLE_CLOUD_PROJECT = [Id of the project]
REGION_NAME = [Region name]
## Build the sample

Install [Maven](http://maven.apache.org/).

Build your project with:

```
mvn clean package
```

### Dataset API

#### Create a new dataset
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.DatasetApi" \
-Dexec.args="create_dataset test_dataset"
```

#### List datasets
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.DatasetApi" \
-Dexec.args="list_datasets"
```

#### Get dataset
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.DatasetApi" \
-Dexec.args="get_dataset [dataset-id]"
```

#### Import data
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.DatasetApi" \
-Dexec.args="import_data [dataset-id] gs://cloud-ml-data/img/flower_photos/train_set.csv"
```

### Model API

#### Create Model
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.ModelApi" \
-Dexec.args="create_model [dataset-id] test_model [training-budget] "
```

#### List Models
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.ModelApi" \
-Dexec.args="list_models"
```

#### Get Model
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.ModelApi" \
-Dexec.args="get_model [model-id]"
```

#### List Model Evaluations
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.ModelApi" \
-Dexec.args="list_model_evaluation [model-id]"
```

#### Get Model Evaluation
```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.ModelApi" \
-Dexec.args="get_model_evaluation [model-id] [model-evaluation-id]"
```

#### Delete Model
```
mvn exec:java-Dexec.mainClass="com.google.cloud.vision.samples.automl.ModelApi" \
-Dexec.args="delete_model [model-id]"
```
### Predict API

```
mvn exec:java -Dexec.mainClass="com.google.cloud.vision.samples.automl.PredictionApi" \
-Dexec.args="[model-id] ./resources/dandelion.jpg 0.7"
```


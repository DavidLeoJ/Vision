/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snippets.healthcare.hl7v2;

// [START healthcare_hl7v2_store_set_iam_policy]

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.healthcare.v1beta1.CloudHealthcare;
import com.google.api.services.healthcare.v1beta1.CloudHealthcare.Projects.Locations.Datasets.Hl7V2Stores;
import com.google.api.services.healthcare.v1beta1.CloudHealthcareScopes;
import com.google.api.services.healthcare.v1beta1.model.Binding;
import com.google.api.services.healthcare.v1beta1.model.Policy;
import com.google.api.services.healthcare.v1beta1.model.SetIamPolicyRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Hl7v2StoreSetIamPolicy {
  private static final String HL7v2_NAME = "projects/%s/locations/%s/datasets/%s/hl7V2Stores/%s";
  private static final JsonFactory JSON_FACTORY = new JacksonFactory();
  private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();

  public static void hl7v2StoreSetIamPolicy(String hl7v2StoreName) throws IOException {
    // String hl7v2StoreName =
    //    String.format(
    //        HL7v2_NAME, "your-project-id", "your-region-id", "your-dataset-id", "your-hl7v2-id");

    // Initialize the client, which will be used to interact with the service.
    CloudHealthcare client = createClient();

    // Configure the IAMPolicy to apply to the store.
    // For more information on understanding IAM roles, see the following:
    // https://cloud.google.com/iam/docs/understanding-roles
    Binding binding =
        new Binding()
            .setRole("roles/healthcare.hl7V2Consumer")
            .setMembers(Arrays.asList("domain:google.com"));
    Policy policy = new Policy().setBindings(Arrays.asList(binding));
    SetIamPolicyRequest policyRequest = new SetIamPolicyRequest().setPolicy(policy);

    // Create request and configure any parameters.
    Hl7V2Stores.SetIamPolicy request =
        client
            .projects()
            .locations()
            .datasets()
            .hl7V2Stores()
            .setIamPolicy(hl7v2StoreName, policyRequest);

    // Execute the request and process the results.
    Policy updatedPolicy = request.execute();
    System.out.println("HL7v2 policy has been updated: " + updatedPolicy.toPrettyString());
  }

  private static CloudHealthcare createClient() throws IOException {
    // Use Application Default Credentials (ADC) to authenticate the requests
    // For more information see https://cloud.google.com/docs/authentication/production
    GoogleCredential credential =
        GoogleCredential.getApplicationDefault(HTTP_TRANSPORT, JSON_FACTORY)
            .createScoped(Collections.singleton(CloudHealthcareScopes.CLOUD_PLATFORM));

    // Create a HttpRequestInitializer, which will provide a baseline configuration to all requests.
    HttpRequestInitializer requestInitializer =
        request -> {
          credential.initialize(request);
          request.setHeaders(new HttpHeaders().set("X-GFE-SSL", "yes"));
          request.setConnectTimeout(60000); // 1 minute connect timeout
          request.setReadTimeout(60000); // 1 minute read timeout
        };

    // Build the client for interacting with the service.
    return new CloudHealthcare.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer)
        .setApplicationName("your-application-name")
        .build();
  }
}
// [END healthcare_hl7v2_store_set_iam_policy]

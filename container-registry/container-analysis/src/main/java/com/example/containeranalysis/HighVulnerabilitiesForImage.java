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

package com.example.containeranalysis;

// [START containeranalysis_filter_vulnerability_occurrences]
import com.google.cloud.devtools.containeranalysis.v1.ContainerAnalysisClient;
import io.grafeas.v1.GrafeasClient;
import io.grafeas.v1.Occurrence;
import io.grafeas.v1.ProjectName;
import io.grafeas.v1.Severity;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HighVulnerabilitiesForImage {
  // Retrieve a list of vulnerability occurrences with a severity level of 'HIGH' or greater
  public static List<Occurrence> findHighSeverityVulnerabilitiesForImage(String resourceUrl,
      String projectId) throws IOException {
    // String resourceUrl = "https://gcr.io/project/image@sha256:123";
    // String projectId = "my-project-id";
    final String projectName = ProjectName.format(projectId);
    String filterStr = String.format("kind=\"VULNERABILITY\" AND resourceUrl=\"%s\"", resourceUrl);

    // Initialize client that will be used to send requests. After completing all of your requests, 
    // call the "close" method on the client to safely clean up any remaining background resources.
    GrafeasClient client = ContainerAnalysisClient.create().getGrafeasClient();
    LinkedList<Occurrence> vulnerabilitylist = new LinkedList<Occurrence>();
    for (Occurrence o : client.listOccurrences(projectName, filterStr).iterateAll()) {
      Severity severity = o.getVulnerability().getSeverity();
      if (severity == Severity.HIGH || severity == Severity.CRITICAL) {
        vulnerabilitylist.add(o);
      }
    }
    return vulnerabilitylist;
  }
}
// [END containeranalysis_filter_vulnerability_occurrences]

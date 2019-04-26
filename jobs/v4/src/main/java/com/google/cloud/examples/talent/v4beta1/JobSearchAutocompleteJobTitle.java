// DO NOT EDIT! This is a generated sample ("Request",  "job_search_autocomplete_job_title")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CompleteQueryRequest;
import com.google.cloud.talent.v4beta1.CompleteQueryResponse;
import com.google.cloud.talent.v4beta1.CompleteQueryResponse.CompletionResult;
import com.google.cloud.talent.v4beta1.CompletionClient;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_autocomplete_job_title]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.CompleteQueryRequest;
 * import com.google.cloud.talent.v4beta1.CompleteQueryResponse;
 * import com.google.cloud.talent.v4beta1.CompleteQueryResponse.CompletionResult;
 * import com.google.cloud.talent.v4beta1.CompletionClient;
 * import com.google.cloud.talent.v4beta1.TenantName;
 * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
 * import java.util.Arrays;
 * import java.util.List;
 */
public class JobSearchAutocompleteJobTitle {
  /** Complete job title given partial text (autocomplete) */
  public static void sampleCompleteQuery(
      String projectId, String tenantId, String query, int numResults, String languageCode) {
    // [START job_search_autocomplete_job_title_core]
    try (CompletionClient completionClient = CompletionClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      // String query = "[partially typed job title]";
      // int numResults = 5;
      // String languageCode = "en-US";
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      List<String> languageCodes = Arrays.asList(languageCode);
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setParent(parent.toString())
              .setQuery(query)
              .setPageSize(numResults)
              .addAllLanguageCodes(languageCodes)
              .build();
      CompleteQueryResponse response = completionClient.completeQuery(request);
      for (CompleteQueryResponse.CompletionResult result : response.getCompletionResultsList()) {
        System.out.printf("Suggested title: %s\n", result.getSuggestion());
        // Suggestion type is JOB_TITLE or COMPANY_TITLE
        System.out.printf("Suggestion type: %s\n", result.getType());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_autocomplete_job_title_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("query").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("num_results").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("language_code").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String query = cl.getOptionValue("query", "[partially typed job title]");
    int numResults =
        cl.getOptionValue("num_results") != null
            ? Integer.parseInt(cl.getOptionValue("num_results"))
            : 5;
    String languageCode = cl.getOptionValue("language_code", "en-US");

    sampleCompleteQuery(projectId, tenantId, query, numResults, languageCode);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_autocomplete_job_title]

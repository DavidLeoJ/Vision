// DO NOT EDIT! This is a generated sample ("Request",  "job_search_batch_delete_job")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_batch_delete_job]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.BatchDeleteJobsRequest;
 * import com.google.cloud.talent.v4beta1.JobServiceClient;
 * import com.google.cloud.talent.v4beta1.TenantName;
 * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
 */
public class JobSearchBatchDeleteJob {
  /**
   * Batch delete jobs using a filter
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenantd
   * @param filter The filter string specifies the jobs to be deleted. For example: companyName =
   *     "projects/api-test-project/companies/123" AND equisitionId = "req-1"
   */
  public static void sampleBatchDeleteJobs(String projectId, String tenantId, String filter) {
    // [START job_search_batch_delete_job_core]
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      // String filter = "[Query]";
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      BatchDeleteJobsRequest request =
          BatchDeleteJobsRequest.newBuilder()
              .setParent(parent.toString())
              .setFilter(filter)
              .build();
      jobServiceClient.batchDeleteJobs(request);
      System.out.println("Batch deleted jobs from filter");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_batch_delete_job_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("filter").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String filter = cl.getOptionValue("filter", "[Query]");

    sampleBatchDeleteJobs(projectId, tenantId, filter);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_batch_delete_job]

// DO NOT EDIT! This is a generated sample ("RequestPaged",  "job_search_list_jobs")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.ListJobsRequest;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_list_jobs]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.Job;
 * import com.google.cloud.talent.v4beta1.JobServiceClient;
 * import com.google.cloud.talent.v4beta1.ListJobsRequest;
 * import com.google.cloud.talent.v4beta1.TenantName;
 * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
 */
public class JobSearchListJobs {
  /**
   * List Jobs
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenant
   */
  public static void sampleListJobs(String projectId, String tenantId, String filter) {
    // [START job_search_list_jobs_core]
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      // String filter = "companyName=projects/my-project/companies/company-id";
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      ListJobsRequest request =
          ListJobsRequest.newBuilder().setParent(parent.toString()).setFilter(filter).build();
      for (Job responseItem : jobServiceClient.listJobs(request).iterateAll()) {
        System.out.printf("Job name: %s\n", responseItem.getName());
        System.out.printf("Job requisition ID: %s\n", responseItem.getRequisitionId());
        System.out.printf("Job title: %s\n", responseItem.getTitle());
        System.out.printf("Job description: %s\n", responseItem.getDescription());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_list_jobs_core]
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
    String filter =
        cl.getOptionValue("filter", "companyName=projects/my-project/companies/company-id");

    sampleListJobs(projectId, tenantId, filter);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_list_jobs]

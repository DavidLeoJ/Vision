// DO NOT EDIT! This is a generated sample ("Request",  "job_search_delete_job")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.DeleteJobRequest;
import com.google.cloud.talent.v4beta1.JobName;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.JobWithTenantName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_delete_job]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.DeleteJobRequest;
 * import com.google.cloud.talent.v4beta1.JobName;
 * import com.google.cloud.talent.v4beta1.JobServiceClient;
 * import com.google.cloud.talent.v4beta1.JobWithTenantName;
 */
public class JobSearchDeleteJob {
  /** Delete Job */
  public static void sampleDeleteJob(String projectId, String tenantId, String jobId) {
    // [START job_search_delete_job_core]
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      // String jobId = "Company ID";
      JobName name = JobWithTenantName.of(projectId, tenantId, jobId);
      DeleteJobRequest request = DeleteJobRequest.newBuilder().setName(name.toString()).build();
      jobServiceClient.deleteJob(request);
      System.out.println("Deleted job.");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_delete_job_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("job_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String jobId = cl.getOptionValue("job_id", "Company ID");

    sampleDeleteJob(projectId, tenantId, jobId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_delete_job]

// DO NOT EDIT! This is a generated sample ("Request",  "job_search_get_job")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.GetJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobName;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.JobWithTenantName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_get_job]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.GetJobRequest;
 * import com.google.cloud.talent.v4beta1.Job;
 * import com.google.cloud.talent.v4beta1.JobName;
 * import com.google.cloud.talent.v4beta1.JobServiceClient;
 * import com.google.cloud.talent.v4beta1.JobWithTenantName;
 */
public class JobSearchGetJob {
  /** Get Job */
  public static void sampleGetJob(String projectId, String tenantId, String jobId) {
    // [START job_search_get_job_core]
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      // String jobId = "Job ID";
      JobName name = JobWithTenantName.of(projectId, tenantId, jobId);
      GetJobRequest request = GetJobRequest.newBuilder().setName(name.toString()).build();
      Job response = jobServiceClient.getJob(request);
      System.out.printf("Job name: %s\n", response.getName());
      System.out.printf("Requisition ID: %s\n", response.getRequisitionId());
      System.out.printf("Title: %s\n", response.getTitle());
      System.out.printf("Description: %s\n", response.getDescription());
      System.out.printf("Posting language: %s\n", response.getLanguageCode());
      for (String address : response.getAddressesList()) {
        System.out.printf("Address: %s\n", address);
      }
      for (String email : response.getApplicationInfo().getEmailsList()) {
        System.out.printf("Email: %s\n", email);
      }
      for (String websiteUri : response.getApplicationInfo().getUrisList()) {
        System.out.printf("Website: %s\n", websiteUri);
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_get_job_core]
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
    String jobId = cl.getOptionValue("job_id", "Job ID");

    sampleGetJob(projectId, tenantId, jobId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_get_job]

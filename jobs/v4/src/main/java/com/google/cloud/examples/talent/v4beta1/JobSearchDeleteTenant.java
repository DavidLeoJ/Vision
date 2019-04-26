// DO NOT EDIT! This is a generated sample ("Request",  "job_search_delete_tenant")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_delete_tenant]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.DeleteTenantRequest;
 * import com.google.cloud.talent.v4beta1.TenantName;
 * import com.google.cloud.talent.v4beta1.TenantServiceClient;
 */
public class JobSearchDeleteTenant {
  /** Delete Tenant */
  public static void sampleDeleteTenant(String projectId, String tenantId) {
    // [START job_search_delete_tenant_core]
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID)";
      TenantName name = TenantName.of(projectId, tenantId);
      DeleteTenantRequest request =
          DeleteTenantRequest.newBuilder().setName(name.toString()).build();
      tenantServiceClient.deleteTenant(request);
      System.out.println("Deleted Tenant.");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_delete_tenant_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID)");

    sampleDeleteTenant(projectId, tenantId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_delete_tenant]

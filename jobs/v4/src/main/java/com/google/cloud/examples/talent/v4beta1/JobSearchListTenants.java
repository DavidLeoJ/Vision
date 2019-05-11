// DO NOT EDIT! This is a generated sample ("RequestPaged",  "job_search_list_tenants")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.ListTenantsRequest;
import com.google.cloud.talent.v4beta1.ProjectName;
import com.google.cloud.talent.v4beta1.Tenant;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_list_tenants]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.ListTenantsRequest;
 * import com.google.cloud.talent.v4beta1.ProjectName;
 * import com.google.cloud.talent.v4beta1.Tenant;
 * import com.google.cloud.talent.v4beta1.TenantServiceClient;
 */
public class JobSearchListTenants {
  /** List Tenants */
  public static void sampleListTenants(String projectId) {
    // [START job_search_list_tenants_core]
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      ProjectName parent = ProjectName.of(projectId);
      ListTenantsRequest request =
          ListTenantsRequest.newBuilder().setParent(parent.toString()).build();
      for (Tenant responseItem : tenantServiceClient.listTenants(request).iterateAll()) {
        System.out.printf("Tenant Name: %s\n", responseItem.getName());
        System.out.printf("External ID: %s\n", responseItem.getExternalId());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_list_tenants_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");

    sampleListTenants(projectId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_list_tenants]

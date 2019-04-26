// DO NOT EDIT! This is a generated sample ("Request",  "job_search_create_tenant")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CreateTenantRequest;
import com.google.cloud.talent.v4beta1.ProjectName;
import com.google.cloud.talent.v4beta1.Tenant;
import com.google.cloud.talent.v4beta1.TenantServiceClient;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_create_tenant]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.CreateTenantRequest;
 * import com.google.cloud.talent.v4beta1.ProjectName;
 * import com.google.cloud.talent.v4beta1.Tenant;
 * import com.google.cloud.talent.v4beta1.TenantServiceClient;
 */
public class JobSearchCreateTenant {
  /** Create Tenant for scoping resources, e.g. companies and jobs */
  public static void sampleCreateTenant(String projectId, String externalId) {
    // [START job_search_create_tenant_core]
    try (TenantServiceClient tenantServiceClient = TenantServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String externalId = "Your Unique Identifier for Tenant";
      ProjectName parent = ProjectName.of(projectId);
      Tenant tenant = Tenant.newBuilder().setExternalId(externalId).build();
      CreateTenantRequest request =
          CreateTenantRequest.newBuilder().setParent(parent.toString()).setTenant(tenant).build();
      Tenant response = tenantServiceClient.createTenant(request);
      System.out.println("Created Tenant");
      System.out.printf("Name: %s\n", response.getName());
      System.out.printf("External ID: %s\n", response.getExternalId());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_create_tenant_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("external_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String externalId = cl.getOptionValue("external_id", "Your Unique Identifier for Tenant");

    sampleCreateTenant(projectId, externalId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_create_tenant]

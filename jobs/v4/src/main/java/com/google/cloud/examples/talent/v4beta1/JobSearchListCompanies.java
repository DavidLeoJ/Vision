// DO NOT EDIT! This is a generated sample ("RequestPaged",  "job_search_list_companies")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.Company;
import com.google.cloud.talent.v4beta1.CompanyServiceClient;
import com.google.cloud.talent.v4beta1.ListCompaniesRequest;
import com.google.cloud.talent.v4beta1.TenantName;
import com.google.cloud.talent.v4beta1.TenantOrProjectName;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_list_companies]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.Company;
 * import com.google.cloud.talent.v4beta1.CompanyServiceClient;
 * import com.google.cloud.talent.v4beta1.ListCompaniesRequest;
 * import com.google.cloud.talent.v4beta1.TenantName;
 * import com.google.cloud.talent.v4beta1.TenantOrProjectName;
 */
public class JobSearchListCompanies {
  /**
   * List Companies
   *
   * @param projectId Your Google Cloud Project ID
   * @param tenantId Identifier of the Tenant
   */
  public static void sampleListCompanies(String projectId, String tenantId) {
    // [START job_search_list_companies_core]
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      TenantOrProjectName parent = TenantName.of(projectId, tenantId);
      ListCompaniesRequest request =
          ListCompaniesRequest.newBuilder().setParent(parent.toString()).build();
      for (Company responseItem : companyServiceClient.listCompanies(request).iterateAll()) {
        System.out.printf("Company Name: %s\n", responseItem.getName());
        System.out.printf("Display Name: %s\n", responseItem.getDisplayName());
        System.out.printf("External ID: %s\n", responseItem.getExternalId());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_list_companies_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");

    sampleListCompanies(projectId, tenantId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_list_companies]

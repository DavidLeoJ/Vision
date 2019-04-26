// DO NOT EDIT! This is a generated sample ("Request",  "job_search_delete_company")
package com.google.cloud.examples.talent.v4beta1;

import com.google.cloud.talent.v4beta1.CompanyName;
import com.google.cloud.talent.v4beta1.CompanyServiceClient;
import com.google.cloud.talent.v4beta1.CompanyWithTenantName;
import com.google.cloud.talent.v4beta1.DeleteCompanyRequest;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

// [START job_search_delete_company]
/*
 * Please include the following imports to run this sample.
 *
 * import com.google.cloud.talent.v4beta1.CompanyName;
 * import com.google.cloud.talent.v4beta1.CompanyServiceClient;
 * import com.google.cloud.talent.v4beta1.CompanyWithTenantName;
 * import com.google.cloud.talent.v4beta1.DeleteCompanyRequest;
 */
public class JobSearchDeleteCompany {
  /** Delete Company */
  public static void sampleDeleteCompany(String projectId, String tenantId, String companyId) {
    // [START job_search_delete_company_core]
    try (CompanyServiceClient companyServiceClient = CompanyServiceClient.create()) {
      // String projectId = "Your Google Cloud Project ID";
      // String tenantId = "Your Tenant ID (using tenancy is optional)";
      // String companyId = "ID of the company to delete";
      CompanyName name = CompanyWithTenantName.of(projectId, tenantId, companyId);
      DeleteCompanyRequest request =
          DeleteCompanyRequest.newBuilder().setName(name.toString()).build();
      companyServiceClient.deleteCompany(request);
      System.out.println("Deleted company");
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
    // [END job_search_delete_company_core]
  }

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("project_id").build());
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("tenant_id").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("company_id").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String projectId = cl.getOptionValue("project_id", "Your Google Cloud Project ID");
    String tenantId = cl.getOptionValue("tenant_id", "Your Tenant ID (using tenancy is optional)");
    String companyId = cl.getOptionValue("company_id", "ID of the company to delete");

    sampleDeleteCompany(projectId, tenantId, companyId);
  }
}
// FIXME: Insert here clean-up code.

// [END job_search_delete_company]

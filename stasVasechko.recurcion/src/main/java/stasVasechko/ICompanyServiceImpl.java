package stasVasechko;

import java.util.List;

public class ICompanyServiceImpl implements ICompanyService {
    @Override
    public Company GetTopLevelParent(Company cornetCompany) {
        Company result = cornetCompany;
        if(cornetCompany.getParent()!= null) {
            result = GetTopLevelParent(cornetCompany.getParent());
        }
        return result;
    }

    @Override
    public long getEmployeeCountForCompanyChildren(Company company, List<Company> companies) {

       long result = 0L;

       for (Company comp : companies){
           if (comp == company) {
               result += comp.getEmployeeCount();
           }
           else if (CompanyIsParent(company, comp)) {
               result += comp.getEmployeeCount();
           }
       }

        return result;
    }

    public boolean CompanyIsParent(Company parent, Company child){

        if(child == null) {
            return false;
        }
        else if (child.getParent() == parent){
            return true;
        } else {
            return CompanyIsParent(parent, child.getParent());
        }
    }
}

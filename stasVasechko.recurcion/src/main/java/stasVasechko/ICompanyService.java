package stasVasechko;

import java.util.List;

public interface ICompanyService {

    Company GetTopLevelParent(Company child);

    long getEmployeeCountForCompanyChildren(Company company, List<Company> companies);

}

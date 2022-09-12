package stasVasechko;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

class CompanyServiceTest {

    @Test
    public void whenCompanySingleThenTopSameCompany(){
        Company root = new Company(null, 0);
        ICompanyService service = new  ICompanyServiceImpl();
        Company result = service.GetTopLevelParent(root);
        assertSame(result, root);
    }

    @Test
    public void whenCompanyNotSingleThenGetTopCompany(){
        Company root = new Company(null, 0);
        Company dev = new Company(root, 0);
        Company sandbox = new Company(dev, 0);
        ICompanyService service = new  ICompanyServiceImpl();
        assertSame(service.GetTopLevelParent(root), root);
        assertSame(service.GetTopLevelParent(dev), root);
        assertSame(service.GetTopLevelParent(sandbox), root);
    }

    @Test
    public void whenCompanySingleThenCountEmployeeSameCompany(){
        Company root = new Company(null, 10);
        ICompanyService service = new  ICompanyServiceImpl();

        List <Company> companies = new ArrayList<>();
        companies.add(root);

        Long result = service.getEmployeeCountForCompanyChildren(root, companies);

        assertSame(result, 10L);
    }

    @Test
    public void whenCompanyTreeThenCountEmployeeAllCompanys(){

        Company root = new Company(null, 10);
        Company root2 = new Company(null, 10);
        Company dev_root = new Company(root, 10);
        Company sandbox = new Company(dev_root, 10);
        Company sandbox2 = new Company(dev_root, 10);
        Company sandboxRoot2 = new Company(root2, 10);

        ICompanyService service = new  ICompanyServiceImpl();

        List <Company> companies = new ArrayList<>();
        companies.add(root);
        companies.add(root2);
        companies.add(dev_root);
        companies.add(sandbox);
        companies.add(sandbox2);
        companies.add(sandboxRoot2);

        Long result = service.getEmployeeCountForCompanyChildren(dev_root, companies);

        assertSame(result, 30L);
    }

    @Test
    public void whenCompanyNotSingleThenGetParent(){

        Company root = new Company(null, 10);
        Company root2 = new Company(null, 10);
        Company dev_root = new Company(root, 10);
        Company sandbox = new Company(dev_root, 10);
        Company sandbox2 = new Company(dev_root, 10);
        Company sandboxRoot2 = new Company(root2, 10);

        ICompanyServiceImpl service = new  ICompanyServiceImpl();

        boolean result = service.CompanyIsParent(dev_root, sandbox2);

        assertSame(result, true);
    }

}
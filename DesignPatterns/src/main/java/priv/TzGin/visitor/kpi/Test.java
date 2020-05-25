package priv.TzGin.visitor.kpi;

public class Test {
    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();

        System.out.println("===============CEO看报表==============");
        report.showReport(new CEOVisitor());
        System.out.println("===============CTO看报表==============");
        report.showReport(new CTOVisitor());
    }
}

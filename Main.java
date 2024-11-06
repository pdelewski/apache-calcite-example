import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.hep.HepPlanner;
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.prepare.PlannerImpl;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.validate.SqlConformanceEnum;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;
import org.apache.calcite.tools.RelBuilder;
import org.apache.calcite.plan.RelOptUtil;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;

public class Main {
    public static void main(String[] args) {       
	try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
           context.eval("python", "print('Hello from GraalPy!')");
           context.eval("python", "import site");
           context.eval("python", "import sqlglot");
	}
    }
}

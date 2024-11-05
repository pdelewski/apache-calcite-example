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

public class Main {
    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        // Define the SQL query
     String sql = "SELECT name, age FROM users WHERE age > 30";

        // Initialize the parser configuration
        SqlParser.Config config = SqlParser.config();

        // Parse the SQL statement
        SqlParser parser = SqlParser.create(sql, config);
        try {
            SqlNode sqlNode = parser.parseQuery();
            System.out.println("Parsed SQL AST: ");
            System.out.println(sqlNode.toString());
        } catch (Exception e) {
            System.err.println("Failed to parse SQL: " + e.getMessage());
        }

	try (Context context = Context.create()) {
           context.eval("python", "print('Hello from GraalPy!')");
	}

    }
}

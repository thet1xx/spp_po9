import java.util.ArrayList;
import java.util.List;

public class Page {

    private List<Line> lines;

    public Page() {
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}

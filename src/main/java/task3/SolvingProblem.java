package task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolvingProblem extends AbstractPastime implements Actionable {
    public String problem;

    @Override
    public String startJustDoIt() {
        this.status = PastimeStatus.inProcess;
        return "Приступили к решению проблемы: " + problem;
    }

    @Override
    public String stopJustDoIt() {
        this.status = PastimeStatus.finished;
        return "Проблема: " + problem + ", решена";
    }

    @Override
    public String toString(){
        return "Проблема: " + problem + ", статус: " + this.status.name();
    }
}

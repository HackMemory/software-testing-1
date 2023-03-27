package task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Universe {
    public String name;
    public int dimension;

    @Override
    public String toString(){
        return "Вы находитесь здесь: " + this.name;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null
                || this.getClass() != obj.getClass())
            return false;

        Universe u1 = (Universe)obj;

        return this.name.equals(u1.getName()) && this.dimension == u1.getDimension();
    }
}

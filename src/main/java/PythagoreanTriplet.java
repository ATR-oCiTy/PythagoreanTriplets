import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTripletBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PythagoreanTriplet))
            return false;
        Pythagor    eanTriplet other = (PythagoreanTriplet) o;
        return a == other.a && b == other.b && c == other.c;
    }

    static class PythagoreanTripletBuilder{
        private int factorsLessThanOrEqualTo;
        private int sumTo;

        PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int value){
            factorsLessThanOrEqualTo = value;
            return this;
        }

        PythagoreanTripletBuilder thatSumTo(int value) {
            sumTo = value;
            return this;
        }

        List<PythagoreanTriplet> build()
        {
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            for (int x = 1; x <= factorsLessThanOrEqualTo / 2; x++)
            {
                for (int y = x + 1; y <= (factorsLessThanOrEqualTo - x) / 2; y++)
                {
                    if (y != x) {
                        int c = sumTo - (x + y);
                        if (c != y) {
                            if (x * x + y * y == c * c) {
                                triplets.add(new PythagoreanTriplet(x, y, c));
                            }
                        }
                    }
                }
            }
            return triplets;
        }


    }
}

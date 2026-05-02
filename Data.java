import java.util.Random;

public class Data {
	private Random rand;
	private double treeLossAcres;

	private final double spatialResolutionArea = 0.14; // km^2

	public Data() {
		rand = new Random();
		treeLossAcres = rand.nextDouble(126023.745 - 42007.9148) + 42007.9148;
	}

	public double getArea() {
		return ((int) (treeLossAcres * 100)) / 100.0;
	}

	public double cost() {
		double cost = 36.75;
		return ((int) (cost * treeLossAcres * 100)) / 100.0;
	}

	public String probability() {
		Random r = new Random();
		double randNum = (r.nextInt(10) + 1) / 10.0;
		if(randNum <= 0.5) {
			return "unlikely";
		}
		else {
			return "possible";
		}
	}
}
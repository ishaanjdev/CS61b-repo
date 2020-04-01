public class NBody { 

public static double readRadius(String input_string){
	In in = new In(input_string);
	int N = in.readInt();
	double R = in.readDouble();
	return R;
}

public static Planet[] readPlanets(String input_string) {
	In in = new In(input_string);
	int N = in.readInt();
	double R = in.readDouble();
	Planet[] planet_array = new Planet[N];
	int count = 0;
	while (count < N){
		planet_array[count] =new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		count += 1;
	}
	return planet_array;
}
 	
public static void main(String[] args){
	double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	double R = readRadius(filename);
	Planet[] planets = readPlanets(filename);
	StdDraw.clear();
	StdDraw.setScale(-R, R);
	String background = "images/starfield.jpg";
	StdDraw.picture(0, 0,background);
	double radius = R;
		for (int i = 0; i < planets.length ; i +=1){
			planets[i].draw();

		} 

	StdDraw.enableDoubleBuffering();
	StdDraw.show();

	for (double time = 0; time <= T; time += dt ){
		
		double[] xForces = new double[planets.length];
			/* create an array of x net forces */
			for (int i =0; i < planets.length; i+=1){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
			}


		double[] yForces = new double[planets.length];
			/* create an array of y net forces */
			for (int i =0; i < planets.length; i+=1){
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				}

		for (int i =0; i < planets.length; i+=1){
			planets[i].update(dt, xForces[i], yForces[i]);
		}
		StdDraw.clear();
		StdDraw.setScale(-R, R);
		StdDraw.picture(0, 0,background);
		for (int i = 0; i < planets.length ; i +=1){
			planets[i].draw();
		}
		StdDraw.show(); 
		StdDraw.pause(10);
	}
	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < planets.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
	}  
} 

}
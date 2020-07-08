import java.util.Arrays;
public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		in.readInt();
		double radius = in.readDouble();
		return radius;

	}

	public static Body[] readBodies(String filename) {
		In in = new In(filename);
		//In class reads line by line.
		int num = in.readInt();
		in.readDouble();
		Body[] bodies = new Body[num];
		for(int i = 0; !in.isEmpty() && i < num; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			Body b = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			bodies[i] = b;
		}
		return bodies;

	}

	public static void main(String[] args) {
		//Collecting all needed input
		NBody pd = new NBody ();
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = pd.readRadius(filename);
		Body[] bodies = pd.readBodies(filename);

		

		
		//Drawing the background
		String imageToDraw = "images/starfield.jpg";
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0,imageToDraw);
		StdDraw.show();

		//Drawing one body
		for (Body b : bodies) {
			b.draw();
		}  

		//Creating An Animation

		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time <= T) {
			Double[] xForces = new Double[bodies.length];
			Double[] yForces = new Double[bodies.length];
			
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
				bodies[i].update(dt, xForces[i], yForces[i]);

			}
			StdDraw.enableDoubleBuffering();
			//Without drawing the background after each update, you will see the trejetory of the planets
			StdDraw.picture(0,0,imageToDraw);
			for (Body b : bodies) {
				b.draw();
				} 
			StdDraw.show();
			StdDraw.pause(10);
				
			time += dt;

		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
   			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
}

		
	}
}

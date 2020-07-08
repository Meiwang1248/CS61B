import java.util.Arrays;
import java.util.ArrayList;

public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	
	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;

	}
	public double calcDistance(Body b1) {
		double dx = this.xxPos - b1.xxPos;
		double dy = this.yyPos - b1.yyPos;
		double distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
		 
	}

	public double calcForceExertedBy (Body b1) {
		double G = 6.67e-11;
		double r_square = Math.pow(this.calcDistance(b1), 2);
		double F = (this.mass * b1.mass * G) / r_square;
		return F;
	}

	public double calcForceExertedByX (Body b1) {
		double F = this.calcForceExertedBy(b1);
		double dx = this.xxPos - b1.xxPos;
		double r = this.calcDistance(b1);
		if(this.xxPos < b1.xxPos) {
			return (F * -dx) / r;
		}else {
			return (F * dx) / r;
		}		 

	}

	public double calcForceExertedByY (Body b1) {
		double F = this.calcForceExertedBy(b1);
		double dy = this.yyPos - b1.yyPos;
		double r = this.calcDistance(b1);
		if(this.yyPos < b1.yyPos) {
			return (F * -dy) / r;
		}else {
			return (F * dy) / r;
		}

	}

	
	public double calcNetForceExertedByX(Body[] bs) {
        double FxNet = 0;
        for (Body b : bs) {
            if (!this.equals(b)) {
                FxNet += this.calcForceExertedByX(b);
            }
        }
        return FxNet;
    }

    public double calcNetForceExertedByY(Body[] bs) {
        double FyNet = 0;
        for (Body b : bs) {
            if (!this.equals(b)) {
                FyNet += this.calcForceExertedByY(b);
            }
        }
        return FyNet;
    }

	
	public void update(double dt, double fx, double fy) {
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		xxVel = this.xxVel + ax * dt;
		yyVel = this.yyVel + ay * dt;
		xxPos = this.xxPos + dt * xxVel;
		yyPos = this.yyPos + dt * yyVel;
	}
	
	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName); 
		StdDraw.show();
		
	}	
}
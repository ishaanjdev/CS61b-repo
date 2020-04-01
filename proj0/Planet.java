public class Planet {
	public double xxPos;   	
		/* current x positiom */
	public double yyPos;		
		/* current y position */ 
	public double xxVel;	
		/* current velocity in the x dir */
	public double yyVel;	
		/* current velocity in the y dir */
	public double mass;
		/* planet's mass*/ 
	public String imgFileName;
		/* the name of the file that has the image of the planet*/	

	private static final double Gv = 6.67e-11; 
		/* gravitational constant */

public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m ;
		imgFileName = img;


	}
public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass ;
		imgFileName = p.imgFileName;


}

public double calcDistance(Planet p){
	return Math.sqrt((this.xxPos -  p.xxPos)*(this.xxPos -  p.xxPos) + (this.yyPos -  p.yyPos) * (this.yyPos -  p.yyPos)) ;
}

public double calcForceExertedBy(Planet p){
	return (Gv * this.mass * p.mass)/(this.calcDistance(p)*this.calcDistance(p));
}

public double calcForceExertedByX(Planet p){
	/* if "this" has a higher value than p in the x-direction, then the force needs to be negative.*/
	if (this.xxPos > p.xxPos){
			return (this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)) / this.calcDistance(p);
	}
	else if (this.xxPos < p.xxPos) {
		return (this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)) / this.calcDistance(p);
	}
	else {
		return 0;
	}
}

public double calcForceExertedByY(Planet p){
	if (this.yyPos > p.yyPos){
			return (this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)) / this.calcDistance(p);
	}
	else if (this.yyPos < p.yyPos){
		return (this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)) / this.calcDistance(p);
	}
	else {
		return 0;
	}
}
public double calcNetForceExertedByX(Planet[] manyp){
	double netX = 0;
	for (int i = 0; i < manyp.length; i = i + 1){
		if (this.equals(manyp[i])){
			continue;
		}

		netX = netX + this.calcForceExertedByX(manyp[i]); 

	}

	return netX;
}

public double calcNetForceExertedByY(Planet[] manyp){
	double netY = 0;
	for (int i = 0; i < manyp.length; i +=1){
		if (this.equals(manyp[i])){
			continue;
		}

		netY = netY + this.calcForceExertedByY(manyp[i]);
	}
	return netY;
}


public void update(double dt, double fx, double fy){
	double accelx=fx/this.mass;
	double accely=fy/this.mass;
	this.xxVel = this.xxVel + dt * accelx;
	this.yyVel = this.yyVel + dt * accely;
	this.xxPos = this.xxPos + dt * this.xxVel; 
	this.yyPos = this.yyPos + dt * this.yyVel; 

}

public void draw(){
	StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
}













}
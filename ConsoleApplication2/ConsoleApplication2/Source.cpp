#include <iostream>
#include <istream>
#include <string>
using namespace std;
class Calculator{
double a, b;
string sign;
public:
	Calculator(){};
	Calculator(double a, string sign, double b){
	setA(a);
	setB(b);
	this->sign=sign;
	};
	double getA(){return a;}
	double getB(){return b;}
	void setA(double a){this->a=a;}
	void setB(double b){this->b=b;}
	void result(){
	if(sign=="+"){
			cout<<"Your result is: "<<a+b<<endl;
		}
		if(sign=="-"){
			cout<<"Your result is: "<<a-b<<endl;
		}
		if(sign=="*"){
			cout<<"Your result is: "<<a*b<<endl;
		}
		if(sign=="/"){
			if(b==0){
				cout<<"Wrong input"<<endl;
			}
			else{
				cout<<"Your result is: "<<a/b<<endl;
			}
		}
	}
	void parse(string input){
	    char s2='+';
		char s3='-';
		char s4='*';
		char s5='/';
		for(int i=0;i<input.length();i++){
		if(input[i]==s2||input[i]==s3||input[i]==s4||input[i]==s5)
		{
			string temp=input.substr(0,i);
			string temp2=input.substr(i+1,input.length());
			sign=input[i];
			a=atof(temp.c_str());
			b=atof(temp2.c_str());
		}
		}
	}
};
int main(){
	cout<<"Input expression"<<endl;
	string expression;
	cin>>expression;
	Calculator* calculator=new Calculator();
	calculator->parse(expression);
	calculator->result();
system("pause");
}
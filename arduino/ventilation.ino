#include <AFMotor.h>
#include <DHT.h>
AF_DCMotor motor1(1);
AF_DCMotor motor2(2);
DHT dht(A0, DHT11);
int defaultTem = 0;
int defaultHum = 0;
int autoMode = 1;
int operationFlag = 0;

void setup() {
  Serial.begin(9600);    
  Serial.println("Start");
  motor1.setSpeed(255);
  motor1.run(RELEASE);
  motor2.setSpeed(255);
  motor2.run(RELEASE);
}

void loop() {
  int t = dht.readTemperature();
  int h = dht.readHumidity();

  Serial.print("Temperature:");
  Serial.println(t);
  Serial.print("Humidity:");
  Serial.println(h);

  if (autoMode != 0) {
    if (defaultTem > t && defaultHum > h) {
      motor1.run(RELEASE);
      motor2.run(RELEASE);
    }
    else {
      motor1.run(FORWARD);
      motor2.run(FORWARD);
    }
  }
  else {
    if (operationFlag != 0) {
      motor1.run(FORWARD);
      motor2.run(FORWARD);
    }
    else {
      motor1.run(RELEASE);
      motor2.run(RELEASE);
    }
  }
  
  
  delay(1000);
} 

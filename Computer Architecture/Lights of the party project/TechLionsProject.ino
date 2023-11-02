volatile char dataIn;
bool LSON = false;

#define red_pin 8
#define green_pin 10
#define blue_pin 11
int red= 0;
int green= 0;
int blue= 0;

//testing
#include <SoftwareSerial.h> // use the software uart

int sensor = 2;
int val = 0;
int state = LOW; 

int sig = 0;

int micPin = 3;   // Same thing with the mic connect it to the pin it will be plugged into and insert the number before the semicolon
int micVal = LOW;  //high is off low is on i believe


boolean pwrToggle = true;

//int valS = 0; // light value from the pin
int lightON= 0; // light status either on or off
int heard = 0; // if the noise was heard or not

void setup() {
  Serial.begin(9600);
  pinMode (2, INPUT);
  pinMode(micPin, INPUT_PULLUP); //monitoring the state of the switch
  pinMode(8, OUTPUT);
}

void loop() {
 int motion = digitalRead(2);
   
  while (Serial.available() > 0) {
    
       
    dataIn = Serial.read(); 
    if (dataIn == 'r') {
        digitalWrite(8,HIGH);
        LSON = true;       
    }

    else if (dataIn == 'g') {
        analogWrite(10,255);
        LSON = true;
    }

    else if (dataIn == 'b') {
        analogWrite(11,255);
        LSON = true;       
    }  

    else if (dataIn == 'm') {
     motionSenor();
    }
    
    else if (dataIn == 'a') {
      alarm();
    }

   else if (dataIn == 'o'){
    if (LSON == true) {
        digitalWrite(8,LOW);
        analogWrite(10,0);
        analogWrite(11,0);
        LSON = false;
    } 
   }

   else if (dataIn == 's') {
    sound();
   }

   else if (dataIn == 'j') {
    music();
   }
  }
}

void motionSenor(){
  while(dataIn != 'h'){
    dataIn = Serial.read();
    val = digitalRead(sensor);   // read sensor value
    if (val == HIGH) {           // check if the sensor is HIGH
      digitalWrite(8, HIGH);   // turn LED ON
    
      if (state == LOW) {
        state = HIGH;       // update variable state to HIGH
      }
      delay(5000);
    } 
    else {
        digitalWrite(8, LOW); // turn LED OFF
        delay(500);             // delay 200 milliseconds 
      
        if (state == HIGH){
          state = LOW;       // update variable state to LOW
        }
    } 
  }
}

void sound(){
  while (dataIn != 't') {
    dataIn = Serial.read();
    lightON = digitalRead(8);
     micVal = digitalRead(micPin);
        if(micVal == HIGH && lightON == LOW) {
            digitalWrite(8, HIGH);
            delay(150);
        }
        else if (micVal == HIGH && lightON == HIGH){
            digitalWrite(8, LOW);
            delay(150);
        }
  }
  digitalWrite(8, LOW);
} 

void alarm(){
  while(dataIn != 'k'){
    dataIn = Serial.read();
    val = digitalRead(sensor);   // read sensor value
    if (val == HIGH) {           // check if the sensor is HIGH    
       while(dataIn != 'k') {
        dataIn = Serial.read();
        Serial.println("Alert! ALERT!!!!"); 
        digitalWrite(8, HIGH);   // turn red ON
        analogWrite(11, 0);       //blue off
        delay(500);
        analogWrite(10,255);    // green on
        digitalWrite(8, LOW);   // turn red Off
        delay(500);
        analogWrite(11,255);    // blue on
        analogWrite(10, 0);   // turn green Off
        delay(500);
       }
    } 
  }
   analogWrite(11, 0);       //blue off
   digitalWrite(8, LOW);   // turn red Off
   analogWrite(10, 0);   // turn green Off
}

void music() {

  while (dataIn != 'q') {
    dataIn = Serial.read();
    red = digitalRead(red_pin);
    blue = digitalRead(blue_pin);
    green = digitalRead(green_pin);
    micVal = digitalRead(micPin);
   
        if(micVal == HIGH && red == LOW && blue == LOW && green == LOW) { //works
            digitalWrite(red_pin, HIGH);
            delay(150);
        }
        else if (micVal == HIGH && red == HIGH && blue == LOW && green == LOW){ //works
            analogWrite(blue_pin, 255);
            delay(150);
        }
        else if (micVal == HIGH && red == HIGH && blue == HIGH && green == LOW){ //works
            analogWrite(green_pin, 255);
            delay(150);
        }
        else if (micVal == HIGH && red == HIGH && blue == HIGH && green == HIGH){ //works
            digitalWrite(red_pin, LOW);
            delay(150);
        }
        else if (micVal == HIGH && red == LOW && blue == HIGH && green == HIGH){ //works
            analogWrite(blue_pin, 0);
            digitalWrite(red_pin, HIGH);
            delay(150);
        }
        else if (micVal == HIGH && red == HIGH && blue == LOW && green == HIGH){ //works
            digitalWrite(red_pin, LOW);
            delay(150);
        }
        else if (micVal == HIGH && red == LOW && blue == LOW && green == HIGH){
            analogWrite(blue_pin, 255);
            analogWrite(green_pin, 0);
            delay(150);
        }
        else if (micVal == HIGH && red == LOW && blue == HIGH && green == LOW){
            analogWrite(blue_pin, 0);
            digitalWrite(red_pin, HIGH);
            delay(150);
        }
  }
  analogWrite(blue_pin, 0);
  analogWrite(green_pin, 0);
  digitalWrite(red_pin, LOW);
}

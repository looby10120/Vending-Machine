/*ตอนนี้เครื่องขายสามารถ
 - เพิ่ม,ลด เหรียญได้
 - เพิ่ม,ลด สินค้าได้
 - ซื้อสินค้าได้
 - กดทอนตังได้
 - แสดงสินค้าแล้วกดรับได้
 - เข้าหน้าแอดมินได้
 - รีเซ็ตเครื่องและ simulator ได้
 บัคที่พบ คือ เหรียญในเครื่องเป็น0ทำให้การทอนตังติดลบหรือไม่ทอนเลย แก้ไขแล้ว
*/

int money = 0;
int total_money = 0;
int buy = 0;
int warning = 0;
int [] jewel_stock = {10, 10, 10, 10, 10};  // ruby, sapphire, topaz, emerald, diamond instock
int [] jewel_money = {0, 0, 0, 0, 0};       // ruby, sapphire, topaz, emerald, diamond sold price
int [] jewel_amount = {0, 0, 0, 0, 0};      // ruby, sapphire, topaz, emerald, diamond sold amount
int [] jewel_drop = {0, 0, 0, 0, 0};        // ruby, sapphire, topaz, emerald, diamond drop after click buy
int [] get_coin = {0, 0, 0};                // coin 1, coin 5, coin 10 insert
int [] display_coin = {0,0,0};
int [] coin = {20, 20, 20};                 // coin 1, coin 5, coin 10 in machine
int [] change = {0, 0, 0};                  // coin 1, coin 5, coin 10 change amount
boolean admin = false;

void setup() {
  size(900, 600);
  frameRate(10);
}
void draw() {                              // Switch between Vending Machine and Admin Zone
  background(#FFFFCC);

  if (keyPressed && key == CODED) {
    if (keyCode == LEFT && buy == 0) {
      admin = true;
    } else if (keyCode == RIGHT) {
      admin = false;
    }
  }
  if (admin == true) {
    Admin(0, 0);
  } else if (admin == false) {
    vending(0, 0);
  }

  // after click buy jewel appear in drop zone
  if (jewel_drop[0] == 1) {
    ruby(120, 350);
  } 
  if (jewel_drop[1] == 1) {
    sapphire(100, 350);
  } 
  if (jewel_drop[2] == 1) {
    topaz(70, 350);
  } 
  if (jewel_drop[3] == 1) {
    emerald(65, 333);
  } 
  if (jewel_drop[4] == 1) {
    diamond(115, 335);
  }
}

void vending(int x, int y) {  

  //Body
  fill(#F7BE81);                             
  rect(50, 50, 750, 500);
  //Showcase
  fill(#81F7F3);                             
  rect(70, 70, 400, 300);

  //Jewel Tags
  fill(255);                                 
  rect(80, 160, 110, 50);
  rect(200, 160, 135, 50);
  rect(345, 160, 115, 50);
  rect(135, 300, 130, 50);
  rect(280, 300, 140, 50);

  //jewel
  ruby(0, 0);
  sapphire(100, 0);
  topaz(200, 0);
  emerald(5, 120);
  diamond(200, 120);

  //Tags information
  fill(0);
  textSize(15);
  text("Ruby 15 Baht", 87, 180);
  text("Qt. " +jewel_stock[0], 110, 200);

  text("Sapphire 20 Baht", 207, 180);
  text("Qt. " +jewel_stock[1], 245, 200);

  text("Topaz 30 Baht", 350, 180);
  text("Qt. " +jewel_stock[2], 378, 200);

  text("Emerald 45 Baht", 141, 320);
  text("Qt. " +jewel_stock[3], 175, 340);

  text("Diamond 50 Baht", 287, 320);
  text("Qt. " +jewel_stock[4], 325, 340);

  //Jewel Drop zone
  fill(#666666);
  rect(140, 420, 250, 100);

  //Divide body zone
  fill(#FF3300);
  rect(490, 50, 40, 500);

  //Machine Name
  fill(#DDDDDD);
  rect(560, 70, 210, 70);
  fill(0);
  textSize(10);
  text("Total 1 coin Baht inserted = " +display_coin[0], 570, 90);
  text("Total 5 coin Baht inserted = " +display_coin[1], 570, 110);
  text("Total 10 coin Baht inserted = " +display_coin[2], 570, 130);

  //Show coin inserted
  fill(#00FFFF);
  rect(690, 170, 80, 35);
  fill(0);
  textSize(25);
  text(+money, 700, 197);

  //Payment section
  fill(#DDDDDD);
  rect(690, 220, 50, 100); 
  ellipse(715, 240, 30, 30);
  fill(0);
  rect(710, 225, 10, 30, 10);
  rect(695, 262, 40, 15, 10);
  fill(#FFFF00);
  rect(700, 285, 30, 30, 5);

  //Buying Buttom
  fill(#FF0000);
  ellipse(660, 190, 30, 20);
  fill(#0000FF);
  ellipse(660, 220, 30, 20);
  fill(#FFFF00);
  ellipse(660, 250, 30, 20);
  fill(#00FF00);
  ellipse(660, 280, 30, 20);
  fill(#FFFFFF);
  ellipse(660, 310, 30, 20);

  //Describe Tags Buttom
  fill(255);
  rect(550, 180, 80, 20);
  rect(550, 210, 80, 20);
  rect(550, 240, 80, 20);
  rect(550, 270, 80, 20);
  rect(550, 300, 80, 20);

  fill(0);
  textSize(15);
  text("Ruby", 575, 195);
  text("Sapphire", 560, 225);
  text("Topaz", 570, 255);
  text("Emerald", 562, 285);
  text("Diamond", 560, 315);

  //Coin Buttom
  fill(#DDDDDD);
  ellipse(770, 240, 25, 25);
  ellipse(770, 270, 25, 25);
  ellipse(770, 300, 25, 25);
  fill(0);
  text("1", 766, 245);
  text("5", 766, 275);
  text("10", 761, 305);

  //Change return
  fill(#00FFFF);
  rect(550, 350, 60, 30);
  rect(550, 400, 60, 30);
  rect(550, 450, 60, 30);

  fill(0);
  textSize(15);
  text("1 Baht change", 620, 370);
  text(change[0], 557, 370);
  text("5 Baht change", 620, 420);
  text(change[1], 557, 420);
  text("10 Baht change", 620, 470);
  text(change[2], 557, 470);

  text("Warning : Machine eat coin when run out of coin so insert coin to fit the product price.",50,30);

  if(warning == 1){
    textSize(20);
    text("Sorry out of coin",580,530);
  }
  
    text("Press Left Arrow to switch to admin zone and Press Right Arrow to switch back to vending machine.",160,580);

}

// draw all jewel
void ruby(int x, int y) {
  stroke(0);
  fill(#FF0000);
  ellipse(x+135, y+115, 40, 70);

  fill(#F78181);
  ellipse(x+141, y+100, 10, 20);
}

void sapphire(int x, int y) {

  fill(#0000FF);
  triangle(120+x, 85+y, 215+x, 85+y, 168+x, 150+y);
  fill(#50B4FF);
  triangle(146+x, 100+y, 190+x, 100+y, 168+x, 130+y);

  line(120+x, 85+y, 146+x, 100+y);
  line(215+x, 85+y, 190+x, 100+y);
  line(168+x, 150+y, 168+x, 130+y);
}

void topaz(int x, int y) {

  fill(#FFFF00);
  quad(150+x, 117+y, 200+x, 85+y, 250+x, 117+y, 200+x, 150+y);
  fill(#FFFF99);
  quad(170+x, 117+y, 200+x, 100+y, 230+x, 117+y, 200+x, 135+y);

  line(150+x, 117+y, 170+x, 117+y);
  line(200+x, 85+y, 200+x, 100+y);
  line(250+x, 117+y, 230+x, 117+y);
  line(200+x, 150+y, 200+x, 135+y);
}

void emerald(int x, int y) {
  fill(#00FF00);
  beginShape();
  vertex(170+x, 105+y);
  vertex(230+x, 105+y);
  vertex(240+x, 120+y);
  vertex(240+x, 150+y);
  vertex(230+x, 165+y);
  vertex(170+x, 165+y);
  vertex(160+x, 150+y);
  vertex(160+x, 120+y);
  vertex(170+x, 105+y);
  endShape();

  fill(#98FB98);
  beginShape();
  vertex(180+x, 120+y);
  vertex(220+x, 120+y);
  vertex(225+x, 130+y);
  vertex(225+x, 140+y);
  vertex(220+x, 150+y);
  vertex(180+x, 150+y);
  vertex(175+x, 140+y);
  vertex(175+x, 130+y);
  vertex(180+x, 120+y);
  endShape();

  line(170+x, 105+y, 180+x, 120+y);
  line(230+x, 105+y, 220+x, 120+y);
  line(240+x, 120+y, 225+x, 130+y);
  line(240+x, 150+y, 225+x, 140+y);
  line(230+x, 165+y, 220+x, 150+y);
  line(170+x, 165+y, 180+x, 150+y);
  line(160+x, 150+y, 175+x, 140+y);
  line(160+x, 120+y, 175+x, 130+y);
}

void diamond(int x, int y) {
  fill(255);
  beginShape();
  vertex(110+x, 125+y);
  vertex(125+x, 105+y);
  vertex(175+x, 105+y);
  vertex(190+x, 125+y);
  vertex(150+x, 165+y);
  vertex(110+x, 125+y);
  endShape();

  line(110+x, 125+y, 190+x, 125+y);
  line(130+x, 125+y, 150+x, 165+y);
  line(170+x, 125+y, 150+x, 165+y);
  line(125+x, 105+y, 130+x, 125+y);
  line(130+x, 125+y, 150+x, 105+y);
  line(150+x, 105+y, 170+x, 125+y);
  line(170+x, 125+y, 175+x, 105+y);
}

//Admin insert/remove jewel stock
void keyPressed() {
  if (key == 'r' && jewel_stock[0] < 100 && admin == true) {
    jewel_stock[0] += 1;
  } else if (key == 's' && jewel_stock[1] < 100 && admin == true) {
    jewel_stock[1] += 1;
  } else if (key == 't' && jewel_stock[2] < 100 && admin == true) {
    jewel_stock[2] += 1;
  } else if (key == 'e' && jewel_stock[3] < 100 && admin == true) {
    jewel_stock[3] += 1;
  } else if (key == 'd' && jewel_stock[4] < 100 && admin == true) {
    jewel_stock[4] += 1;
  } else if (key == 'R' && jewel_stock[0] > 0 && admin == true) {
    jewel_stock[0] -= 1;
  } else if (key == 'S' && jewel_stock[1] > 0 && admin == true) {
    jewel_stock[1] -= 1;
  } else if (key == 'T' && jewel_stock[2] > 0 && admin == true) {
    jewel_stock[2] -= 1;
  } else if (key == 'E' && jewel_stock[3] > 0 && admin == true) {
    jewel_stock[3] -= 1;
  } else if (key == 'D' && jewel_stock[4] > 0 && admin == true) {
    jewel_stock[4] -= 1;
  } 

  //Admin insert/remove coin
  else if (key == 'i' && coin[0] < 100 && admin == true) {
    coin[0] += 1;
  } else if (key == 'v' && coin[1] < 100 && admin == true) {
    coin[1] += 1;
  } else if (key == 'x' && coin[2] < 100 && admin == true) {
    coin[2] += 1;
  } else if (key == 'I' && coin[0] > 0 && admin == true) {
    coin[0] -= 1;
  } else if (key == 'V' && coin[1] > 0 && admin == true) {
    coin[1] -= 1;
  } else if (key == 'X' && coin[2] > 0 && admin == true) {
    coin[2] -= 1;
  }

  //Reset Machine
  else if (key == 'z' && admin == true) {
    jewel_amount[0] = 0;
    jewel_amount[1] = 0;
    jewel_amount[2] = 0;
    jewel_amount[3] = 0;
    jewel_amount[4] = 0;
    get_coin[0] = 0;
    get_coin[1] = 0;
    get_coin[2] = 0;
    coin[0] = 20;
    coin[1] = 20;
    coin[2] = 20;
  }

  //Reset Simulator
  else if (key == 'Z' && admin == true) {
    jewel_stock[0] = 10;
    jewel_stock[1] = 10;
    jewel_stock[2] = 10;
    jewel_stock[3] = 10;
    jewel_stock[4] = 10;
    jewel_money[0] = 0;
    jewel_money[1] = 0;
    jewel_money[2] = 0;
    jewel_money[3] = 0;
    jewel_money[4] = 0;
    jewel_amount[0] = 0;
    jewel_amount[1] = 0;
    jewel_amount[2] = 0;
    jewel_amount[3] = 0;
    jewel_amount[4] = 0;
    coin[0] = 20;
    coin[1] = 20;
    coin[2] = 20;
    get_coin[0] = 0;
    get_coin[1] = 0;
    get_coin[2] = 0;
  }
}

//Admin zone
void Admin(int x, int y) {
  total_money = coin[0] + (coin[1]*5) + (coin[2]*10) + jewel_money[0] + jewel_money[1] + jewel_money[2] + jewel_money[3] + jewel_money[4];
  background(0);

  fill(#FFFFFF);
  textSize(50);
  text("Admin Zone", 300, 70);

  textSize(20);
  text("History", 340, 130);
  textSize(15);
  text("Total Ruby sold = " +jewel_amount[0], 370, 170);
  text("Total Sapphire sold = " +jewel_amount[1], 370, 190);
  text("Total Topaz sold = " +jewel_amount[2], 370, 210);
  text("Total Emerald sold = " +jewel_amount[3], 370, 230);
  text("Total Diamond sold = " +jewel_amount[4], 370, 250);

  textSize(20);
  text("Money Section", 50, 130);
  textSize(15);
  text("Total 1 coin Baht = " +coin[0], 80, 170);
  text("Total 5 coin Baht = " +coin[1], 80, 190);
  text("Total 10 coin Baht = " +coin[2], 80, 210);
  text("Total 1 coin Baht inserted = " +get_coin[0], 80, 250);
  text("Total 5 coin Baht inserted = " +get_coin[1], 80, 270);
  text("Total 10 coin Baht inserted = " +get_coin[2], 80, 290);
  text("Total money = " +total_money+ " Baht", 80, 310);

  textSize(20);
  text("Product Section", 600, 130);
  textSize(15);
  text("Total Ruby instock = " +jewel_stock[0], 630, 170);
  text("Total Sapphire instock = " +jewel_stock[1], 630, 190);
  text("Total Topaz instock = " +jewel_stock[2], 630, 210);
  text("Total Emerald instock = " +jewel_stock[3], 630, 230);
  text("Total Diamond instock = " +jewel_stock[4], 630, 250);

  //Instruction
  fill(0);
  stroke(#FFFFFF);
  rect(550, 280, 340, 310);
  fill(#FFFFFF);
  textSize(23);
  text("Instruction", 660, 310);
  textSize(17);
  text("Press r,s,t,e,d to Increase jewel ", 565, 360);
  text("Press R,S,T,E,D to Decrease jewel ", 565, 400);
  text("Press i,v,x to Increase coin ", 565, 440);
  text("Press I,V,X to Decrease coin ", 565, 480);
  text("Press z to Reset machine ", 565, 520);
  text("Press Z to Reset simulator ", 565, 560);
}

//Insert money
void mouseClicked() {
  if (mouseX>=755 && mouseX<=780 && mouseY>=227 && mouseY<=250 && admin == false && buy == 0) {
    money += 1;
    get_coin[0] += 1;
    display_coin[0] += 1;
    coin[0] += 1;
  } else if (mouseX>=755 && mouseX<=780 && mouseY>=257 && mouseY<=280 && admin == false && buy == 0) {
    money += 5;
    get_coin[1] += 1;
    display_coin[1] += 1;
    coin[1] += 1;
  } else if (mouseX>=755 && mouseX<=780 && mouseY>=287 && mouseY<=310 && admin == false && buy == 0) {
    money += 10;
    get_coin[2] += 1;
    display_coin[2] += 1;
    coin[2] += 1;
  }

  //Buy jewel and can't do anything untill you get your jewel
  if (mouseX>=645 && mouseX<=675 && mouseY>=180 && mouseY<=200 && money >= 15 && jewel_stock[0]>0 && admin == false && buy == 0 && jewel_drop[0] == 0) {
    money -= 15;
    jewel_stock[0] -= 1;
    jewel_amount[0] += 1;
    jewel_money[0] += 15;
    jewel_drop[0] = 1;
    buy = 3;
  } else if (mouseX>=645 && mouseX<=675 && mouseY>=210 && mouseY<=230 && money >= 20 && jewel_stock[1]>0 && admin == false && buy == 0 && jewel_drop[1] == 0) {
    money -= 20;
    jewel_stock[1] -= 1;
    jewel_amount[1] += 1;
    jewel_money[1] += 20;
    jewel_drop[1] = 1;
    buy = 3;
  } else if (mouseX>=645 && mouseX<=675 && mouseY>=240 && mouseY<=260 && money >= 30 && jewel_stock[2]>0 && admin == false && buy == 0 && jewel_drop[2] == 0) {
    money -= 30;
    jewel_stock[2] -= 1;
    jewel_amount[2] += 1;
    jewel_money[2] += 30;
    jewel_drop[2] = 1;
    buy = 3;
  } else if (mouseX>=645 && mouseX<=675 && mouseY>=270 && mouseY<=290 && money >= 45 && jewel_stock[3]>0 && admin == false && buy == 0 && jewel_drop[3] == 0) {
    money -= 45;
    jewel_stock[3] -= 1;
    jewel_amount[3] += 1;
    jewel_money[3] += 45;
    jewel_drop[3] = 1;
    buy = 3;
  } else if (mouseX>=645 && mouseX<=675 && mouseY>=300 && mouseY<=320 && money >= 50 && jewel_stock[4]>0 && admin == false && buy == 0 && jewel_drop[4] == 0) {
    money -= 50;
    jewel_stock[4] -= 1;
    jewel_amount[4] += 1;
    jewel_money[4] += 50;
    jewel_drop[4] = 1;
    buy = 3;
  } 

  // after click change buttom must get your change before buy the new one
  else if (mouseX>=700 && mouseX<=730 && mouseY>=285 && mouseY<=315 && admin == false && buy == 1) {
    change[0] = 0;
    change[1] = 0;
    change[2] = 0;
    warning = 0;
    buy = 0;
  } else if (mouseX>=700 && mouseX<=730 && mouseY>=285 && mouseY<=315 && admin == false && buy == -1) {
    change[0] = 0;
    change[1] = 0;
    change[2] = 0;
    buy = 0;
  }

  //Coin return
  if (mouseX>=695 && mouseX<=735 && mouseY>=262 && mouseY<=277 && money > 0 && coin[0] <= 0 && coin[1] <= 0 && buy == 2) {
    money = 0;
    display_coin[0] = 0;
    display_coin[1] = 0;
    display_coin[2] = 0;
    warning = 1;
    buy = 1;
  }
  if (mouseX>=695 && mouseX<=735 && mouseY>=262 && mouseY<=277 && money > 0 && admin == false && buy == 2) {
    if (coin[2]>0) {
      change[2] = money/10;
      coin[2] -= change[2];
      money = money%10;
    }
    if (coin[1]>0) {
      change[1] = money/5;
      coin[1] -= change[1];
      money = money%5;
    }
    if (coin[0]>0) {
      change[0] = money;
      coin[0] -= change[0];
      money -= money;
    }
    display_coin[0] = 0;
    display_coin[1] = 0;
    display_coin[2] = 0;
    buy = 1;
  } 

  //Coin return when not buy anything
  else if (mouseX>=695 && mouseX<=735 && mouseY>=262 && mouseY<=277 && money > 0 && admin == false && buy == 0) {
    if (coin[2]>0) {
      change[2] = money/10;
      coin[2] -= change[2];
      money = money%10;
    }
    if (coin[1]>0) {
      change[1] = money/5;
      coin[1] -= change[1];
      money = money%5;
    }
    if (coin[0]>0) {
      change[0] = money;
      coin[0] -= change[0];
      money -= money;
    }
    buy = -1;
  } 

  // get jewel   
  if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[0] == 1 && money == 0) {
    jewel_drop[0] = 0;
    buy = 0;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[1] == 1 && money == 0) {
    jewel_drop[1] = 0;
    buy = 0;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[2] == 1 && money == 0) {
    jewel_drop[2] = 0;
    buy = 0;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[3] == 1 && money == 0) {
    jewel_drop[3] = 0;
    buy = 0;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[4] == 1 && money == 0) {
    jewel_drop[4] = 0;
    buy = 0;
  }

  if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[0] == 1) {
    jewel_drop[0] = 0;
    buy = 2;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[1] == 1) {
    jewel_drop[1] = 0;
    buy = 2;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[2] == 1) {
    jewel_drop[2] = 0;
    buy = 2;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[3] == 1) {
    jewel_drop[3] = 0;
    buy = 2;
  } else if (mouseX>=140 && mouseX<=390 && mouseY>=420 && mouseY<=520 && admin == false && buy == 3 && jewel_drop[4] == 1) {
    jewel_drop[4] = 0;
    buy = 2;
  }
}
//問1
for(var i=1;i<=5;i++){
    document.write("★")
}

document.write("<br><br>");
//問2
for(var a=1;a<=2;a++){
    for(var b=1;b<=3;b++){
        document.write("★");
    }
    document.write("<br>")
}

document.write("<br><br>");
//問3
for(var c=1;c<=2;c++){
    for(var d=1;d<=5;d++){
        document.write("☆");
    }
    document.write("<br>");
}

document.write("<br>");
//問4
for(var e=1;e<=4;e++){
    for(var f=1;f<=5;f++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
//問5
for(g=1;g<=4;g++){
    for(h=1;h<=3;h++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
//問6
for(i=1;i<=3;i++){
    for(j=1;j<=3;j++){
        if(j%2===0){
        document.write("☆");
        }else{
            document.write("★");
        }
    }
    document.write("<br>");
}

document.write("<br>");
//問7
for(k=1;k<=4;k++){
    for(l=1;l<=5;l++){
        if(l%2===0){
            document.write("☆");
        }else{
            document.write("★");
        }
    }
    document.write("<br>");
}

document.write("<br>");

//問8
for(m=1;m<=1;m++){
    document.write("★");
}

document.write("<br>");

for(n=1;n<=2;n++){
    document.write("★");
}

document.write("<br>");

for(o=1;o<=3;o++){
    document.write("★");
}

document.write("<br>");
for(p=1;p<=4;p++){
    document.write("★");
}

document.write("<br>");

for(q=1;q<=5;q++){
    document.write("★");
}

document.write("<br>");
document.write("<br>");

//演習3.問1

function circlearea(rad,Pi=3.14){
    return rad*rad*Pi;
}

document.write(circlearea(5)+"<br>");
document.write(circlearea(7)+"<br>");
document.write(circlearea(10)+"<br>");

document.write("<br>");

//問2

function charge(adult,child){
    return adult*500+child*200+"円です。"
}

document.write(charge(2,4)+"<br>");
document.write(charge(1,5)+"<br>");
document.write(charge(3,7)+"<br>");
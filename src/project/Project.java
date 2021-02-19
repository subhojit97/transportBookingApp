/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.TextBoundsType;
import javafx.scene.control.TextField;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import javafx.scene.text.Font;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

public class Project extends Application
{
    Scene r,r1,r2,r3,r4,r5,r6;
    ChoiceBox c1=new ChoiceBox();
    public void start(Stage st)throws Exception
    {
        Text t=new Text("WELCOME TO SAS TRANSPORT COMPANY");
        t.setLayoutX(100);
        t.setLayoutY(200);
        t.setFont(new Font("",30));
        t.setUnderline(true);
        Image i=new Image("file:C:\\Users\\Subhojit\\Documents\\NetBeansProjects\\project\\src\\busy-road-in-shanghai-at-night-wallpaper-for-3840x2160-4k-136-947.jpg");
        BackgroundSize sq=new BackgroundSize(700,700,true,true,true,false);
        
        BackgroundImage ui=new BackgroundImage(i,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,sq);
        
        Background fg=new Background(ui);
       
        t.setFill(Color.LIGHTGREEN);
        Button b=new Button(" Admin");
      
        b.setLayoutX(120);
        b.setLayoutY(350);
        b.setFont(new Font("",20));
        Button b1=new Button("Customer ");
        b1.setLayoutX(230);
        b1.setLayoutY(350);
       b1.setFont(new Font("",20));
        Button b2=new Button("Forum ");
        b2.setLayoutX(470);
        b2.setLayoutY(350);
        b2.setFont(new Font("",20));
        Button b3=new Button("Driver");
        b3.setLayoutX(370);
        b3.setLayoutY(350);
        b3.setFont(new Font("",20));
        Group g=new Group(t,b,b1,b2,b3);
        Pane p=new Pane(g);
        p.setBackground(fg);
        p.setPrefSize(700,700);
        Scene s=new Scene(p,700,700);
        s.setFill(Color.AQUA);
        st.setTitle("Transport Company");
        st.setScene(s);
        b.setOnAction(new EventHandler<ActionEvent>()
        {
           
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    try {
                      Group  g=register1(s,st);
                         Scene s=new Scene(g,700,700);
                         r=s;
               s.setFill(Color.AQUA);
               st.setScene(s);
               st.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
           
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b1)
                {
                    try {
                      Group  g=registercust(s,st);
                         Scene s=new Scene(g,700,700);
                         r=s;
               s.setFill(Color.AQUA);
               st.setScene(s);
               st.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b3)
                {
                    try {
                      Group  g=registerdriver(s,st);
                         Scene s=new Scene(g,700,700);
                         r=s;
               s.setFill(Color.AQUA);
               st.setScene(s);
               st.show();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } 
                
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b2)
                {
                    Group g=Forum(s,st);
                    Scene s=new Scene(g,700,700);
                    s.setFill(Color.AQUA);
                    st.setScene(s);
                    st.show();
                    
                }
            }
        });
        st.show();
        
        
    }
    Group Forum(Scene s,Stage st)
    {
        Group g=null;
        Text f=new Text("Forum");
        f.setFont(new Font("",30));
        f.setLayoutX(300);
        f.setLayoutY(100);
        f.setUnderline(true);
        TextArea t=new TextArea();
        t.setLayoutX(50);
        t.setLayoutY(150);
        t.setEditable(false);
        new ScrollPane(t);
        TextField t1=new TextField();
        t1.setPrefWidth(450);
        t1.setFont(new Font("",15));
        t1.setLayoutX(110);
        t1.setLayoutY(400);
        Button b=new Button("submit");
        b.setLayoutX(570);
        b.setLayoutY(400);
        Button b1=new Button("Back");
        b1.setLayoutX(50);
        b1.setLayoutY(400);
        try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select message,name from forum";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder be=new StringBuilder();
                               while(rs.next())
                               {
                                   String se=rs.getString("message");
                                   String u=rs.getString("name");
                                   String v=se+"  - by  "+u;
                                   be.append(String.format("%s%n", v));
                               }
                               con.close();
                               stt.close();
                               t.setText(be.toString());
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        b.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    
                    try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="insert into forum values('"+t1.getText()+"','"+"annonymus"+"');";
                               stt.executeUpdate(s2);
                               
                               
                               con.close();
                               stt.close();
                              
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
                    try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select message,name from forum";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder be=new StringBuilder();
                               while(rs.next())
                               {
                                   String se=rs.getString("message");
                                   String u=rs.getString("name");
                                   String v=se+"  - by  "+u;
                                   be.append(String.format("%s%n", v));
                               }
                               con.close();
                               stt.close();
                               t.setText(be.toString());
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
                    t1.setText("");
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b1)
                {
                    st.setScene(s);
                    st.show();
                }
            }
        });
        g=new Group(t,f,t1,b,b1);
        return g;
    }
     Group Forum12(Scene s,Stage st,String fr)
    {
        Group g=null;
        Text f=new Text("Forum");
        f.setFont(new Font("",30));
        f.setLayoutX(300);
        f.setLayoutY(100);
        f.setUnderline(true);
        TextArea t=new TextArea();
        t.setLayoutX(50);
        t.setLayoutY(150);
        t.setEditable(false);
        new ScrollPane(t);
        TextField t1=new TextField();
        t1.setPrefWidth(450);
        t1.setFont(new Font("",15));
        t1.setLayoutX(110);
        t1.setLayoutY(400);
        Button b=new Button("submit");
        b.setLayoutX(570);
        b.setLayoutY(400);
        Button b1=new Button("Back");
        b1.setLayoutX(50);
        b1.setLayoutY(400);
        try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select message,name from forum";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder be=new StringBuilder();
                               while(rs.next())
                               {
                                   String se=rs.getString("message");
                                   String u=rs.getString("name");
                                   String v=se+"  - by  "+u;
                                   be.append(String.format("%s%n", v));
                               }
                               con.close();
                               stt.close();
                               t.setText(be.toString());
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        b.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    
                    try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="insert into forum values('"+t1.getText()+"','"+fr+"');";
                               stt.executeUpdate(s2);
                               
                               
                               con.close();
                               stt.close();
                              
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
                    try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select message,name from forum";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder be=new StringBuilder();
                               while(rs.next())
                               {
                                   String se=rs.getString("message");
                                   String u=rs.getString("name");
                                   String v=se+"  - by  "+u;
                                   be.append(String.format("%s%n", v));
                               }
                               con.close();
                               stt.close();
                               t.setText(be.toString());
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
                    t1.setText("");
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b1)
                {
                    st.setScene(r2);
                    st.show();
                }
            }
        });
        g=new Group(t,f,t1,b,b1);
        return g;
    }
       Group Forum1(Scene s,Stage st)
    {
        Group g=null;
        Text f=new Text("Forum");
        f.setFont(new Font("",30));
        f.setLayoutX(300);
        f.setLayoutY(100);
        f.setUnderline(true);
        TextArea t=new TextArea();
        t.setLayoutX(50);
        t.setLayoutY(150);
        t.setEditable(false);
        new ScrollPane(t);
        TextField t1=new TextField();
        t1.setPrefWidth(450);
        t1.setFont(new Font("",15));
        t1.setLayoutX(110);
        t1.setLayoutY(400);
        Button b=new Button("submit");
        b.setLayoutX(570);
        b.setLayoutY(400);
        Button b1=new Button("Back");
        b1.setLayoutX(50);
        b1.setLayoutY(400);
        try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select message,name from forum";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder be=new StringBuilder();
                               while(rs.next())
                               {
                                   String se=rs.getString("message");
                                   String u=rs.getString("name");
                                   String v=se+"  - by  "+u;
                                   be.append(String.format("%s%n", v));
                               }
                               con.close();
                               stt.close();
                               t.setText(be.toString());
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        b.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    
                    try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="insert into forum values('"+t1.getText()+"','"+"admin"+"');";
                               stt.executeUpdate(s2);
                               
                               
                               con.close();
                               stt.close();
                              
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
                    try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select message,name from forum";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder be=new StringBuilder();
                               while(rs.next())
                               {
                                   String se=rs.getString("message");
                                   String u=rs.getString("name");
                                   String v=se+"  - by  "+u;
                                   be.append(String.format("%s%n", v));
                               }
                               con.close();
                               stt.close();
                               t.setText(be.toString());
                }
    
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
                    t1.setText("");
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b1)
                {
                    st.setScene(s);
                    st.show();
                }
            }
        });
        g=new Group(t,f,t1,b,b1);
        return g;
    }
    Group registerdriver(Scene sr,Stage st)
    {
        Group g=null;
        Text t=new Text("Driver Page");
        t.setFont(new Font("",30));
        t.setUnderline(true);
        Button b=new Button("Driver Registration");
        Button b1=new Button("Driver Login");
        Button b2=new Button("Back");
        t.setLayoutX(250);
       t.setLayoutY(150);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b2.setLayoutX(100);
       b2.setLayoutY(350);
       g=new Group(t,b,b1,b2);
       b.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b)
               {
                   Group g=registerdriv(sr,st);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
       
        b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
              if(e.getSource()==b1)
              {
                  Group g=logindriv(sr,st);
                  Scene s=new Scene(g,700,700);
                  s.setFill(Color.AQUA);
                  r3=s;
                  st.setScene(s);
                  st.show();
                  
              }
           }
       });
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b2)
               {
                   st.setScene(sr);
                   st.show();
               }
           }
       });
       return g;
    }
     Group logindriv(Scene sr,Stage st)
    {
         Group g=null;
        PasswordField p=new PasswordField();
       TextField f=new TextField();
       Button b=new Button("Log in");
       Button b1=new Button("Back");
       Text t=new Text("Log in Driver");
       t.setFont(new Font("",30));
       t.setUnderline(true);
        b.setOnAction(new EventHandler<ActionEvent>()
               {
                   public void handle(ActionEvent e)
                   {
                       if(e.getSource()==b)
                       {
                           
                           try
                           {
                               String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                               
                               String s2="select username,password,first,last from driver";
                               ResultSet rs=stt.executeQuery(s2);
                               boolean k=false;
                               while(rs.next()){
                                   
                               if(rs.getString("username").equalsIgnoreCase(f.getText())&&rs.getString("password").equals(p.getText()))
                               {
                              
                                       k=true;
                                        fr=rs.getString("first");
                                       ty=rs.getString("username");
                                       spe=rs.getString("first")+" "+rs.getString("last");
                                       break;
                                       
                         
                              
                               }
                               
                               
                               }
                               if(k==true)
                               {
                                  
                                       
                                       Group g=driveroption(sr,st,spe,ty,fr);
                                       
                                       Scene s=new Scene(g,700,700);
                                       
                                       s.setFill(Color.AQUA);
                                       r2=s;
                                       st.setScene(s);
                                       st.show();
                               }
                               else
                               {
                                  JOptionPane.showMessageDialog(null,"Wrong Username OR Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
                               }
                               stt.close();
                               con.close();
                               f.setText("");
                                    p.setText("");
                               k=false;
                              
                   
                               
                           }
                           catch(Exception e1)
                           {
                               e1.printStackTrace();
                           }
                           
                       }
                   }
               });
       f.setPrefWidth(200);
       p.setPrefWidth(200);
       Label l=new Label("User :");
       Label l1=new Label("Password :");
       
       t.setLayoutX(250);
       t.setLayoutY(150);
       l1.setLayoutY(300);
       l1.setLayoutX(120);
       l.setLayoutY(250);
       l.setLayoutX(150);
       f.setLayoutX(200);
       f.setLayoutY(250);
       p.setLayoutX(200);
       p.setLayoutY(300);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e1)
           {
               if(e1.getSource()==b1)
               {
                   st.setScene(r);
                   
               st.show();
               }
           }
       });
       g=new Group(f,p,b,l,l1,b1,t);
       return g;
    }
    Group registerdriv(Scene sr,Stage st)
    {
         Group g=null;
        Text t=new Text("Driver registration page");
        t.setFont(new Font("",30));
        t.setUnderline(true);
        TextField f=new TextField();
        TextField f1=new TextField();
        TextField f3=new TextField();
        TextField f4=new TextField();
        TextField f5=new TextField();
        TextField f6=new TextField();
        TextField f7=new TextField();
        TextField f8=new TextField();
        TextField f9=new TextField();
        TextField f10=new TextField();
        TextField f11=new TextField();
        TextField f12=new TextField();
        PasswordField p=new PasswordField();
        Label l=new Label("First Name :");
        Label l1=new Label("Last Name :");
        Label l2=new Label("Address :");
        Label l3=new Label("Age :");
        Label l4=new Label("Pincode :");
        Label l5=new Label("Adhar/Passport No : ");
        Label l6=new Label("Username :");
        Label l7=new Label("Password :");
        Label l8=new Label("License :");
        Label l9=new Label("Car/Truck no :");
        Label l10=new Label("Car/Truck :");
        Label l11=new Label("Car/Truck model :");
        Label l12=new Label("Email :");
        Label l13=new Label("Phone :");
        ChoiceBox c=new ChoiceBox();
        TextField f13=new TextField();
        TextField f14=new TextField();
        c.getItems().addAll("car","truck");
        f13.setPrefWidth(200);
        f14.setPrefWidth(200);
        f12.setPrefWidth(200);//car/truck model
        f10.setPrefWidth(200);//license
        f11.setPrefWidth(200);//car/truck no.        
        f.setPrefWidth(200);//name
        f1.setPrefWidth(200);//surname
        f3.setPrefWidth(200);//address
        f4.setPrefWidth(200);//address
        f5.setPrefWidth(200);//address
        f6.setPrefWidth(50);//age
        f7.setPrefWidth(200);//pincode
        f8.setPrefWidth(200);//username
        f9.setPrefWidth(200);//adhar no. or passport no.
        p.setPrefWidth(200);//password
         t.setLayoutX(200);
       t.setLayoutY(50);
       l.setLayoutX(30);
       l.setLayoutY(150);
       f.setLayoutY(150);
       f.setLayoutX(120);
       l1.setLayoutX(360);
       l1.setLayoutY(150);
       f1.setLayoutX(450);
       f1.setLayoutY(150);
       l2.setLayoutX(50);
       l2.setLayoutY(200);
       f3.setLayoutX(120);
       f3.setLayoutY(200);
       f4.setLayoutX(120);
       f4.setLayoutY(250);
       f5.setLayoutX(120);
       f5.setLayoutY(300);
       l3.setLayoutX(400);
       l3.setLayoutY(200);
       f6.setLayoutX(450);
       f6.setLayoutY(200);
       l4.setLayoutX(370);
       l4.setLayoutY(250);
       f7.setLayoutX(450);
       f7.setLayoutY(250);
       l5.setLayoutX(335);
       l5.setLayoutY(300);
       f9.setLayoutY(300);
       f9.setLayoutX(485);
       l8.setLayoutY(350);
       l8.setLayoutX(50);
       f10.setLayoutX(120);
       f10.setLayoutY(350);
       l9.setLayoutY(350);
       l9.setLayoutX(370);
       f11.setLayoutY(350);
       f11.setLayoutX(485);
       l10.setLayoutX(35);
       l10.setLayoutY(400);
       c.setLayoutX(120);
       c.setLayoutY(400);
       l11.setLayoutX(350);
       l11.setLayoutY(400);
       f12.setLayoutX(485);
       f12.setLayoutY(400);
       l12.setLayoutX(35);
       l12.setLayoutY(450);
       f13.setLayoutX(120);
       f13.setLayoutY(450);
       l13.setLayoutX(400);
       l13.setLayoutY(450);
       f14.setLayoutX(485);
       f14.setLayoutY(450);
       l6.setLayoutX(35);
       l6.setLayoutY(500);
       f8.setLayoutX(120);
       f8.setLayoutY(500);
       l7.setLayoutX(400);
       l7.setLayoutY(500);
       p.setLayoutX(485);
       p.setLayoutY(500);
        Button b=new Button("back");
        Button b1=new Button("submit");
        b.setLayoutY(550);
        b.setLayoutX(120);
        b1.setLayoutX(580);
        b1.setLayoutY(550);
        b.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    st.setScene(r);
                    st.show();
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                int j=JOptionPane.showConfirmDialog(null, "Are you sure with the Information ?");
                if(j==0)
                {
                try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select username from customer";
                               ResultSet rs=stt.executeQuery(s2);
                               
                               int kt=0;
                               
                          
                               while(rs.next())
                               {
                                   
                                   String se=rs.getString("username");
                                   
                                   if(se.equals(f8.getText()))
                                   {
                                       kt=1;
                                       break;
                                   }
                                   else
                                       kt=2;
                               }
                               if(kt==1)
                               {
                                   JOptionPane.showMessageDialog(null,"Username already registered","Error",JOptionPane.ERROR_MESSAGE);
                               }
                               else
                               {
                                   String sq=f3.getText()+f4.getText()+f5.getText();
                                   int kk=Integer.parseInt(f6.getText());
                                   
                         
                                     String s1="insert into driver values('"+f.getText()+"','"+f1.getText()+"','"+sq+"',"+kk+",'"+f7.getText()+"','"+f9.getText()+"','"+f10.getText()+"','"+f11.getText()+"','"+c.getValue()+"','"+f12.getText()+"','"+f8.getText()+"','"+p.getText()+"','"+f13.getText()+"','"+f14.getText()+"','"+"no"+"');";
                               stt.executeUpdate(s1);
                               
                               JOptionPane.showMessageDialog(null, "Driver Registered successfuuly");
                                st.setScene(r);
                                 st.show();
                               
                }
                                stt.close();
                               con.close();
                              
                               
                }
                
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            }
            }
        });
        g=new Group(b,t,l,f,l1,f1,l2,f3,f4,f5,l3,f6,l4,f7,l5,f9,l8,f10,l9,f11,b1,c,l10,l11,f12,l6,l7,f8,p,l12,l13,f13,f14);
        
        return g;
    }
    String hy;
    Group driveroption(Scene sr,Stage st,String spu,String ty,String fr)
    {
        Group g=null;
        
        Button b=new Button("Log out");
        Button b1=new Button(" Delete book");
        Button b2=new Button("check status");
        Button b3=new Button("Forum");
        Text t=new Text("Welcome Driver  :-  "+spu);
        t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(100);
       t.setLayoutY(150);
       b.setLayoutX(500);
       b.setLayoutY(350);
       b1.setLayoutX(130);
       b1.setLayoutY(350);
       b2.setLayoutX(260);
       b2.setLayoutY(350);
       b3.setLayoutX(395);
       b3.setLayoutY(350);
       
       b3.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b3)
               {
                   Group g=Forum12(sr,st,spu+"  (Driver)");
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b2)
               {
                   Group g=check1(sr,st,ty,fr);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
       
       g=new Group(b,b1,b2,t,b3);
    
      b.setOnAction(new EventHandler<ActionEvent>()
      {
          public void handle(ActionEvent e)
          {
              if(e.getSource()==b)
              {
                 int y= JOptionPane.showConfirmDialog(null, "Are you sure you want to log out ?");
                 if(y==0)
                 {
                  r3.setFill(Color.AQUA);
                  st.setScene(r3);
                  st.show();
                 }
              }
          }
      });
      b1.setOnAction(new EventHandler<ActionEvent>()
      {
          public void handle(ActionEvent e)
          {
              if(e.getSource()==b1)
              {
                  deletebook(sr,st,spu,fr);
                  
                  
              }
          }
      });
       
        return g;
    }
    Group check1(Scene sr,Stage st,String ty,String fr)
    {
        Group g=null;
        Text t=new Text("Booked Tickets");
         t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(200);
        t.setLayoutY(100);
       
        Button b=new Button("Back");
         b.setLayoutX(100);
        b.setLayoutY(620);
        TextArea a=new TextArea();
         g=new Group(a,t,b);
        a.setPrefSize(400,400);
        a.setEditable(false);
      a.setLayoutX(100);
       a.setLayoutY(200);
      new ScrollPane(a);
     
       
         try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select first,last,age,email,phone,source,destination,vehicle,model,date,driver from book where driver='"+fr+"'";
                              PreparedStatement d=con.prepareStatement(s2);
                               ResultSet rs=d.executeQuery();
                               int c=0;
                               StringBuilder br=new StringBuilder();
                               while(rs.next())
                               {
                                   ++c;
                                   br.append(String.format("%s",c   ));
                                   br.append(String.format("%s%n","              ************SAS Transport Company********"   ));
                                   br.append(String.format("%s","First : "+rs.getString("first")   ));
                                   br.append(String.format("%s%n","                                   Last : "+rs.getString("last")   ));
                                   br.append(String.format("%s%n","Age : "+rs.getString("age")   ));
                                   br.append(String.format("%s","Email : "+rs.getString("email")   ));
                                   br.append(String.format("%s%n","                                         Phone : "+rs.getString("phone")   ));
                                   br.append(String.format("%s","Source : "+rs.getString("source")  ));
                                   br.append(String.format("%s%n","                                      Destination : "+rs.getString("destination")   ));
                                   br.append(String.format("%s","Vehicle : "+rs.getString("vehicle")   ));
                                   br.append(String.format("%s%n","                                     Model : "+rs.getString("model")   ));
                                   br.append(String.format("%s","Date : "+rs.getString("date")   ));
                                   br.append(String.format("%s%n","                             Driver : "+rs.getString("driver")   ));
                                   
                                   
                               }
                                a.setText(br.toString());
                               
                               
                }
         catch(Exception er)
         {
             
         }
         b.setOnAction(new EventHandler<ActionEvent>()
         {
             public void handle(ActionEvent e)
             {
                 if(e.getSource()==b)
                 {
                     st.setScene(r2);
                     st.show();
                 }
             }
         });
        
        return g;
        
    }
    void deletebook(Scene sr,Stage st,String spu,String ty)
    {
        
        Group g=null;
         try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                       
                               String s2="update driver set book='no' where first='"+ty+"'";
                               String s3="delete from book where driver='"+ty+"'";
                              PreparedStatement d=con.prepareStatement(s2);
                              PreparedStatement d1=con.prepareStatement(s3);
                              d1.executeUpdate();
                               d.executeUpdate();
                               
                             JOptionPane.showMessageDialog(null,"Booking Deleted","Information",JOptionPane.INFORMATION_MESSAGE);
                               
                }
         catch(Exception er)
         {
             
         }
      
    }
    Group customeroption(Scene sr,Stage st,String spu,String ty,String fr)
    {
        Group g=null;
        
        Button b=new Button("Log out");
        Button b1=new Button("Book now");
        Button b2=new Button("check status");
        Button b3=new Button("Forum");
        Text t=new Text("Welcome Customer  :-  "+spu);
        t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(100);
       t.setLayoutY(150);
       b.setLayoutX(500);
       b.setLayoutY(350);
       b1.setLayoutX(130);
       b1.setLayoutY(350);
       b2.setLayoutX(260);
       b2.setLayoutY(350);
       b3.setLayoutX(395);
       b3.setLayoutY(350);
       
       b3.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b3)
               {
                   Group g=Forum12(sr,st,spu);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b2)
               {
                   Group g=check(sr,st,ty,fr);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
       
       g=new Group(b,b1,b2,t,b3);
    
      b.setOnAction(new EventHandler<ActionEvent>()
      {
          public void handle(ActionEvent e)
          {
              if(e.getSource()==b)
              {
                 int y= JOptionPane.showConfirmDialog(null, "Are you sure you want to log out ?");
                 if(y==0)
                 {
                  r3.setFill(Color.AQUA);
                  st.setScene(r3);
                  st.show();
                 }
              }
          }
      });
      b1.setOnAction(new EventHandler<ActionEvent>()
      {
          public void handle(ActionEvent e)
          {
              if(e.getSource()==b1)
              {
                  Group g=book(sr,st,spu,ty);
                  Scene s=new Scene(g,730,700);
                  s.setFill(Color.AQUA);
                  st.setScene(s);
                  st.show();
                  
              }
          }
      });
       
        return g;
    }
    String x,y;
    Group check(Scene sr,Stage st,String ty,String fr)
    {
        Group g=null;
        Text t=new Text("Booked Tickets");
         t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(200);
        t.setLayoutY(100);
       
        Button b=new Button("Back");
         b.setLayoutX(100);
        b.setLayoutY(620);
        TextArea a=new TextArea();
         g=new Group(a,t,b);
        a.setPrefSize(450,400);
        a.setEditable(false);
      a.setLayoutX(100);
       a.setLayoutY(200);
      new ScrollPane(a);
     
       
         try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select first,last,age,email,phone,source,destination,vehicle,model,date,driver from book where first='"+fr+"'";
                              
                              PreparedStatement d=con.prepareStatement(s2);
                               ResultSet rs=d.executeQuery();
                               
                               int c=0;
                               StringBuilder br=new StringBuilder();
                               while(rs.next())
                               {
                                   ++c;
                                    String s3="select phone,email from driver where first='"+rs.getString("driver")+"'";
                                PreparedStatement d1=con.prepareStatement(s3);
                               ResultSet rs1=d1.executeQuery();
                               while(rs1.next())
                               {
                                   x=rs1.getString("email");
                                   y=rs1.getString("phone");
                               }
                                   br.append(String.format("%s",c   ));
                                   br.append(String.format("%s%n","              ************SAS Transport Company********"   ));
                                   br.append(String.format("%s","First : "+rs.getString("first")   ));
                                   br.append(String.format("%s%n","                                   Last : "+rs.getString("last")   ));
                                   br.append(String.format("%s%n","Age : "+rs.getString("age")   ));
                                   br.append(String.format("%s","Email : "+rs.getString("email")   ));
                                   br.append(String.format("%s%n","                                         Phone : "+rs.getString("phone")   ));
                                    br.append(String.format("%s","Driver Email : "+x   ));
                                   br.append(String.format("%s%n","           Driver Phone : "+y   ));
                                   br.append(String.format("%s","Source : "+rs.getString("source")  ));
                                   br.append(String.format("%s%n","                                      Destination : "+rs.getString("destination")   ));
                                   br.append(String.format("%s","Vehicle : "+rs.getString("vehicle")   ));
                                   br.append(String.format("%s%n","                                     Model : "+rs.getString("model")   ));
                                   br.append(String.format("%s","Date : "+rs.getString("date")   ));
                                   br.append(String.format("%s%n","                             Driver : "+rs.getString("driver")   ));
                                   
                                   
                               }
                                a.setText(br.toString());
                               
                               
                }
         catch(Exception er)
         {
             
         }
         b.setOnAction(new EventHandler<ActionEvent>()
         {
             public void handle(ActionEvent e)
             {
                 if(e.getSource()==b)
                 {
                     st.setScene(r2);
                     st.show();
                 }
             }
         });
        
        return g;
        
    }
    
    Group book(Scene sr,Stage st,String spu,String ty)
    {
        Group g=null;
         Text t=new Text("Welcome Customer  :-  "+spu);
        t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(100);
       t.setLayoutY(150);
       Button b2=new Button("check");
       TextField f=new TextField();
       TextField f1=new TextField();
       TextField f2=new TextField();
       ChoiceBox c=new ChoiceBox();
       c.getItems().addAll("Car","truck");
       ChoiceBox c1=new ChoiceBox();
      
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
          
           
           public void handle(ActionEvent e)
           {
               
               c1.getItems().clear();
              if(e.getSource()==b2)
              {
                  
                   if(c.getValue().toString().equals("Car"))
       {
            try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select vehicle,model,book from driver";
                               ResultSet rs=stt.executeQuery(s2);
                               StringBuilder br=new StringBuilder();
                               while(rs.next())
                               {
                                   if(rs.getString("book").equalsIgnoreCase("no"))
                                   if(rs.getString("vehicle").equalsIgnoreCase("car"))
                                   {
                                       br.append(String.format("%s", rs.getString("model")));
                                   }
                               }
                               c1.getItems().addAll(br.toString());
                               stt.close();
                             con.close();
                             
                                br=null;
                }
            catch(Exception e2)
            {
                
            }
       }
                else
                 {
           
           try
                {
                   
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                                String ar[];
                               String s2="select vehicle,model,book from driver";
                               ResultSet rs=stt.executeQuery(s2);
                             
                               int y=0,k=0;
                          
                            
                             ArrayList fo=new ArrayList<String>();
                               while(rs.next())
                               {
                                   
                                   if(rs.getString("book").equals("no"))
                                   if(rs.getString("vehicle").equalsIgnoreCase("truck"))
                                   {
                                      
                                       fo.add(rs.getString("model"));
                                   }
                               }
                               c1.getItems().addAll(fo);
                             
                               stt.close();
                               con.close();
                               fo.clear();
                }
            catch(Exception e2)
            {
                
            }
       }
              }
              
           }
       });
      
       
      
      Button b=new Button("Back");
      Button b1=new Button("Book");
      Label l=new Label("Source :");
      Label l2=new Label("Destination :");
      Label l3=new Label("Vehicle :");
      Label l4=new Label("Model :");
      Label l5=new Label("Date :");
      Label l6=new Label("Driver :");
      Button b3=new Button("check");
      DatePicker p=new DatePicker();
       b3.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
              if(e.getSource()==b3)
              {
                  
                   
       
            try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select vehicle,model,book,first from driver";
                               ResultSet rs=stt.executeQuery(s2);
                               while(rs.next())
                               {
                                   
                                   if(c1.getValue().toString().equalsIgnoreCase(rs.getString("model")))
                                   {
                                       f2.setText(rs.getString("first"));
                                       break;
                                   }
                                   
                               }
                               
                               stt.close();
                             con.close();
                             
                           
                }
            catch(Exception e2)
            {
                
            }
       
               
                 }
              
           }
                   
       });
       
      p.setPrefWidth(200);
      f.setPrefWidth(200);
      f1.setPrefWidth(200);
      f2.setPrefWidth(200);
      f2.setEditable(false);
      l.setLayoutX(50);
      l.setLayoutY(250);
      f.setLayoutX(140);
      f.setLayoutY(250);
      l2.setLayoutX(50);
      l2.setLayoutY(300);
      f1.setLayoutX(140);
      f1.setLayoutY(300);
      l3.setLayoutX(50);
      l3.setLayoutY(350);
      
      c.setLayoutX(110);
      c.setLayoutY(350);
      b2.setLayoutX(190);
      b2.setLayoutY(350);
      l4.setLayoutX(260);
      l4.setLayoutY(350);
      c1.setLayoutX(310);
      c1.setLayoutY(350);
      b3.setLayoutX(410);
      
      b3.setLayoutY(350);
      l5.setLayoutX(440);
      l5.setLayoutY(300);
      l6.setLayoutX(470);
      l6.setLayoutY(350);
      f2.setLayoutX(525);
      f2.setLayoutY(350);
      p.setLayoutX(485);
      p.setLayoutY(300);
       b.setLayoutX(50);
       b.setLayoutY(400);
        b1.setLayoutX(600);
       b1.setLayoutY(400);
       c1.setPrefWidth(100);
       g=new Group(t,l,l2,l3,l4,f,f1,c,c1,b,b1,b2,l5,p,l6,f2,b3);
        b.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    st.setScene(r2);
                    st.show();
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
             
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b1)
                {
                   
                     try
                {
                    
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                                String ar[];
                               String s2="select first,last,age,email,phone from customer where username='"+ty+"'";
                           
                               PreparedStatement ger=con.prepareStatement(s2);
                               ResultSet rs=ger.executeQuery();
                              
                             while(rs.next()){
                               String s3="insert into book values('"+rs.getString("first")+"','"+rs.getString("last")+"','"+rs.getString("age")+"','"+rs.getString("email")+"','"+rs.getString("phone")+"','"+f.getText()+"','"+f1.getText()+"','"+c.getValue().toString()+"','"+c1.getValue().toString()+"','"+p.getValue()+"','"+f2.getText()+"')";
                              
                               stt.executeUpdate(s3);
                               }
                              
                              
                String s4="update driver set book='yes' where model='"+c1.getValue().toString()+"'";
             
                stt.executeUpdate(s4);stt.close();
               
                con.close();
                 JOptionPane.showMessageDialog(null,"Transport Booked !");
                 st.setScene(r2);
                 st.show();
                }
                     catch(Exception er)
                     {
                         
                     }
                }
            }
        });
        return g;
    }
    String spe,ty,fr;
    Group logincusto(Scene sr,Stage st)
    {
         Group g=null;
        PasswordField p=new PasswordField();
       TextField f=new TextField();
       Button b=new Button("Log in");
       Button b1=new Button("Back");
       Text t=new Text("Log in Customer");
       t.setFont(new Font("",30));
       t.setUnderline(true);
        b.setOnAction(new EventHandler<ActionEvent>()
               {
                   public void handle(ActionEvent e)
                   {
                       if(e.getSource()==b)
                       {
                           
                           try
                           {
                               String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                               
                               String s2="select username,password,first,last from customer";
                               ResultSet rs=stt.executeQuery(s2);
                               boolean k=false;
                               while(rs.next()){
                                   
                               if(rs.getString("username").equalsIgnoreCase(f.getText())&&rs.getString("password").equals(p.getText()))
                               {
                              
                                       k=true;
                                        fr=rs.getString("first");
                                       ty=rs.getString("username");
                                       spe=rs.getString("first")+" "+rs.getString("last");
                                       break;
                                       
                         
                              
                               }
                               
                               
                               }
                               if(k==true)
                               {
                                  
                                       
                                       Group g=customeroption(sr,st,spe,ty,fr);
                                       
                                       Scene s=new Scene(g,700,700);
                                       
                                       s.setFill(Color.AQUA);
                                       r2=s;
                                       st.setScene(s);
                                       st.show();
                               }
                               else
                               {
                                  JOptionPane.showMessageDialog(null,"Wrong Username OR Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
                               }
                               stt.close();
                               con.close();
                               f.setText("");
                                    p.setText("");
                               k=false;
                              
                   
                               
                           }
                           catch(Exception e1)
                           {
                               e1.printStackTrace();
                           }
                           
                       }
                   }
               });
       f.setPrefWidth(200);
       p.setPrefWidth(200);
       Label l=new Label("User :");
       Label l1=new Label("Password :");
       
       t.setLayoutX(250);
       t.setLayoutY(150);
       l1.setLayoutY(300);
       l1.setLayoutX(120);
       l.setLayoutY(250);
       l.setLayoutX(150);
       f.setLayoutX(200);
       f.setLayoutY(250);
       p.setLayoutX(200);
       p.setLayoutY(300);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e1)
           {
               if(e1.getSource()==b1)
               {
                   st.setScene(r);
                   
               st.show();
               }
           }
       });
       g=new Group(f,p,b,l,l1,b1,t);
       return g;
    }
    Group registercust(Scene sr,Stage st)
    {
       Group g=null;
        Text t=new Text("Customer Page");
        t.setFont(new Font("",30));
        t.setUnderline(true);
        Button b=new Button("Customer Registration");
        Button b1=new Button("Customer Login");
        Button b2=new Button("Back");
        t.setLayoutX(250);
       t.setLayoutY(200);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b2.setLayoutX(100);
       b2.setLayoutY(350);
       g=new Group(t,b,b1,b2);
       b.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b)
               {
                   Group g=custo(sr,st);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
              if(e.getSource()==b1)
              {
                  Group g=logincusto(sr,st);
                  Scene s=new Scene(g,700,700);
                  s.setFill(Color.AQUA);
                  r3=s;
                  st.setScene(s);
                  st.show();
                  
              }
           }
       });
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b2)
               {
                   st.setScene(sr);
                   st.show();
               }
           }
       });
       return g;
    }
    Group custo(Scene sr,Stage st)
    {
        Group g=null;
        Text t=new Text("Customer registration page");
        t.setFont(new Font("",30));
        t.setUnderline(true);
        TextField f=new TextField();
        TextField f1=new TextField();
        TextField f3=new TextField();
        TextField f4=new TextField();
        TextField f5=new TextField();
        TextField f6=new TextField();
        TextField f7=new TextField();
        TextField f8=new TextField();
        TextField f9=new TextField();
        TextField f10=new TextField();
        TextField f11=new TextField();
        PasswordField p=new PasswordField();
        Label l=new Label("First Name :");
        Label l1=new Label("Last Name :");
        Label l2=new Label("Address :");
        Label l3=new Label("Age :");
        Label l4=new Label("Pincode :");
        Label l5=new Label("Adhar/Passport No : ");
        Label l6=new Label("Username :");
        Label l7=new Label("Password :");
        Label l8=new Label("Email :" );
        Label l9=new Label("phone :");
        f10.setPrefWidth(200);
        f11.setPrefWidth(200);
        f.setPrefWidth(200);//name
        f1.setPrefWidth(200);//surname
        f3.setPrefWidth(200);//address
        f4.setPrefWidth(200);//address
        f5.setPrefWidth(200);//address
        f6.setPrefWidth(50);//age
        f7.setPrefWidth(200);//pincode
        f8.setPrefWidth(200);//username
        f9.setPrefWidth(200);//adhar no. or passport no.
        p.setPrefWidth(200);//password
         t.setLayoutX(150);
       t.setLayoutY(50);
       l.setLayoutX(30);
       l.setLayoutY(150);
       f.setLayoutY(150);
       f.setLayoutX(120);
       l1.setLayoutX(360);
       l1.setLayoutY(150);
       f1.setLayoutX(450);
       f1.setLayoutY(150);
       l2.setLayoutX(50);
       l2.setLayoutY(200);
       f3.setLayoutX(120);
       f3.setLayoutY(200);
       f4.setLayoutX(120);
       f4.setLayoutY(250);
       f5.setLayoutX(120);
       f5.setLayoutY(300);
       l3.setLayoutX(400);
       l3.setLayoutY(200);
       f6.setLayoutX(450);
       f6.setLayoutY(200);
       l4.setLayoutX(370);
       l4.setLayoutY(250);
       f7.setLayoutX(450);
       f7.setLayoutY(250);
       l5.setLayoutX(335);
       l5.setLayoutY(300);
       f9.setLayoutY(300);
       f9.setLayoutX(485);
       l8.setLayoutY(350);
       l8.setLayoutX(50);
       f10.setLayoutX(120);
       f10.setLayoutY(350);
       l9.setLayoutY(350);
       l9.setLayoutX(380);
       f11.setLayoutY(350);
       f11.setLayoutX(460);
       l6.setLayoutX(35);
       l6.setLayoutY(400);
       f8.setLayoutX(120);
       f8.setLayoutY(400);
       l7.setLayoutX(380);
       l7.setLayoutY(400);
       p.setLayoutX(460);
       p.setLayoutY(400);
        Button b=new Button("back");
        Button b1=new Button("submit");
        b.setLayoutY(450);
        b.setLayoutX(120);
        b1.setLayoutX(580);
        b1.setLayoutY(450);
        b.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                if(e.getSource()==b)
                {
                    st.setScene(r);
                    st.show();
                }
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent e)
            {
                int j=JOptionPane.showConfirmDialog(null, "Are you sure with the Information ?");
                if(j==0)
                {
                try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select username from customer";
                               ResultSet rs=stt.executeQuery(s2);
                               
                               int kt=0;
                               
                          
                               while(rs.next())
                               {
                                   
                                   String se=rs.getString("username");
                                   
                                   if(se.equals(f8.getText()))
                                   {
                                       kt=1;
                                       break;
                                   }
                                   else
                                       kt=2;
                               }
                               if(kt==1)
                               {
                                   JOptionPane.showMessageDialog(null,"Username already registered","Error",JOptionPane.ERROR_MESSAGE);
                               }
                               else
                               {
                                   String sq=f3.getText()+f4.getText()+f5.getText();
                                   int kk=Integer.parseInt(f6.getText());
                                   
                                     String s1="insert into customer values('"+f.getText()+"','"+f1.getText()+"','"+sq+"',"+kk+",'"+f7.getText()+"','"+f9.getText()+"','"+f8.getText()+"','"+p.getText()+"','"+f9.getText()+"','"+f10.getText()+"','"+f11.getText()+"');";
                               stt.executeUpdate(s1);
                               
                               JOptionPane.showMessageDialog(null, "Customer Registered successfuuly");
                                st.setScene(r);
                                 st.show();
                               
                }
                                stt.close();
                               con.close();
                              
                               
                }
                
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            }
            }
        });
        g=new Group(b,t,l,f,l1,f1,l2,f3,f4,f5,l3,f6,l4,f7,l5,f9,l6,f8,l7,p,b1,l8,l9,f10,f11);
        
        return g;
    }
    Group register1(Scene sr,Stage st)throws Exception
    {
        Group g=null;
        Text t=new Text("Admin Page");
        t.setFont(new Font("",30));
        t.setUnderline(true);
        Button b=new Button("Admin Registration");
        Button b1=new Button("Admin Login");
        Button b2=new Button("Back");
        t.setLayoutX(250);
       t.setLayoutY(150);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b2.setLayoutX(100);
       b2.setLayoutY(350);
       g=new Group(t,b,b1,b2);
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b2)
               {
                    st.setScene(sr);
                   
               st.show();
               }
           }
       });
      
       b.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b)
                {
                    try
                    {
                          String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select username,password from admin";
                               ResultSet rs=stt.executeQuery(s2);
                               
                               int k=0;
                               while(rs.next())
                               {
                                   String se=rs.getString("username");
                                   if(se.equals(null))
                                       k=0;
                                   else
                                       k++;
                               }
                               
                               if(k==0)
                               {
                  Group  g=register(sr,st);
               Scene s=new Scene(g,700,700);
               s.setFill(Color.AQUA);
               st.setScene(s);
               st.show();
                               }
                               else
                               {
                                   JOptionPane.showMessageDialog(null, "Admin is already registered","Error",JOptionPane.ERROR_MESSAGE);
                               }
                    }
                    catch(Exception e1)
                    {
                        e1.printStackTrace();
                    }
                }
           }
       });
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b1)
               {
                   Group g=sign(sr,st);
                   Scene s=new Scene(g,700,700);
                   r1=s;
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   
                   st.show();
               }
           }
       });
        return g;
        
    }
    Group sign(Scene sr,Stage st)
    {
        Group g=null;
        PasswordField p=new PasswordField();
       TextField f=new TextField();
       Button b=new Button("Log in");
       Button b1=new Button("Back");
       Text t=new Text("Log in Admin");
       t.setFont(new Font("",30));
       t.setUnderline(true);
        b.setOnAction(new EventHandler<ActionEvent>()
               {
                   public void handle(ActionEvent e)
                   {
                       if(e.getSource()==b)
                       {
                           
                           try
                           {
                               String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                               
                               String s2="select username,password from admin";
                               ResultSet rs=stt.executeQuery(s2);
                               while(rs.next()){
                               if(rs.getString("username").equalsIgnoreCase(f.getText()))
                               {
                                   if(rs.getString("password").equals(p.getText()))
                                   {
                                       Group g=adminOption(sr,st);
                                       
                                       Scene s=new Scene(g,700,700);
                                       
                                       s.setFill(Color.AQUA);
                                       r2=s;
                                       st.setScene(s);
                                       st.show();
                                       f.setText("");
                                       p.setText("");
                                       
                                   }
                                   else
                               {
                                   JOptionPane.showMessageDialog(null,"Wrong Password","Error",JOptionPane.ERROR_MESSAGE);
                               }
                               }
                               else
                               {
                                   JOptionPane.showMessageDialog(null,"Wrong Username","Error",JOptionPane.ERROR_MESSAGE);
                               }
                               }
                               stt.close();
                               con.close();
                               
                              
                   
                               
                           }
                           catch(Exception e1)
                           {
                               e1.printStackTrace();
                           }
                           
                       }
                   }
               });
       f.setPrefWidth(200);
       p.setPrefWidth(200);
       Label l=new Label("User :");
       Label l1=new Label("Password :");
       t.setLayoutX(250);
       t.setLayoutY(200);
       l1.setLayoutY(300);
       l1.setLayoutX(120);
       l.setLayoutY(250);
       l.setLayoutX(150);
       f.setLayoutX(200);
       f.setLayoutY(250);
       p.setLayoutX(200);
       p.setLayoutY(300);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e1)
           {
               if(e1.getSource()==b1)
               {
                   st.setScene(r);
                   
               st.show();
               }
           }
       });
       g=new Group(f,p,b,l,l1,b1,t);
       return g;
    }
    Group adminOption(Scene sr ,Stage st)
    {
        Group g=null;
        Button b=new Button("Log out");
        Button b1=new Button("customer info");
        Button b2=new Button("truck info");
        Button b3=new Button("car info");
        Button b4=new Button("Forum");
        Text t=new Text("Welcome Admin");
        t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(250);
       t.setLayoutY(150);
       b.setLayoutX(550);
       b.setLayoutY(350);
       b1.setLayoutX(100);
       b1.setLayoutY(350);
       b2.setLayoutX(250);
       b2.setLayoutY(350);
       b4.setLayoutX(460);
       b4.setLayoutY(350);
       b3.setLayoutX(370);
       b3.setLayoutY(350);
       g=new Group(b,b1,b2,b4,b3,t);
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b1)
               {
                   Group g=customerinfo(sr,st);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   r5=s;
                   st.setScene(s);
                   st.show();
               }
           }
       });
       b3.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b3)
               {
                   Group g=carinfo(sr,st);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   r5=s;
                   st.setScene(s);
                   st.show();
               }
           }
       });
       b4.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b4)
               {
                   Group g=Forum1(r2,st);
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   
                   st.setScene(s);
                   st.show();
               }
           }
       });
       b2.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b2)
               {
                   Group g=truckinfo(sr,st);
                   Scene s=new Scene(g,700,700);
                   r5=s;
                   s.setFill(Color.AQUA);
                   st.setScene(s);
                   st.show();
               }
           }
       });
      b.setOnAction(new EventHandler<ActionEvent>()
      {
          public void handle(ActionEvent e)
          {
              if(e.getSource()==b)
              {
                 int y= JOptionPane.showConfirmDialog(null, "Are you sure you want to log out ?");
                 if(y==0)
                 {
                  r1.setFill(Color.AQUA);
                  st.setScene(r1);
                  st.show();
                 }
              }
          }
      });
       
        return g;
    }
    Group customerinfo(Scene sr,Stage st)
    {
      Group g=null;
      Text t=new Text("Customer information");
      t.setFont(new Font("",30));
         Label l=new Label("Enter customer RegNo :");
        TextField f=new TextField();
         Button b=new Button("submit");
         Button b1=new Button("Back");
          t.setLayoutX(250);
          t.setLayoutY(150);
          t.setUnderline(true);
          f.setPrefWidth(230);
          l.setLayoutY(250);
          l.setLayoutX(60);
          f.setLayoutX(220);
          f.setLayoutY(250);
          b1.setLayoutX(230);
          b1.setLayoutY(300);
         b.setLayoutX(390);
       b.setLayoutY(300);
       b.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b)
               {
                   Group g=custocheck(sr,st,f.getText());
                   f.setText("");
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
               }
           }
       });
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b1)
               {
                   st.setScene(r2);
                   st.show();
               }
           }
       });
       
       g=new Group(t,f,l,b,b1);
        return g;
    }
    Group carinfo(Scene sr,Stage st)
    {
        Group g=null;
        Text t=new Text("Car information");
        t.setFont(new Font("",30));
        t.setUnderline(true);
         Label l=new Label("Enter car No :");
        TextField f=new TextField();
         Button b=new Button("submit");
         Button b1=new Button("Back");
          t.setLayoutX(250);
          t.setLayoutY(150);
          f.setPrefWidth(230);
          l.setLayoutY(250);
          l.setLayoutX(110);
          f.setLayoutX(220);
          f.setLayoutY(250);
          b1.setLayoutX(230);
          b1.setLayoutY(300);
         b.setLayoutX(390);
       b.setLayoutY(300);
       b.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b)
               {
                   Group g=carcheck(sr,st,f.getText());
                   f.setText("");
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
               }
           }
       });
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b1)
               {
                   st.setScene(r2);
                   st.show();
               }
           }
       });
       g=new Group(t,f,l,b,b1);
        return g;
    }
    Group truckinfo(Scene sr,Stage st)
    {
        Group g=null;
         Text t=new Text("Truck information");
         t.setFont(new Font("",30));
         t.setUnderline(true);
         Label l=new Label("Enter truck No :");
        TextField f=new TextField();
         Button b=new Button("submit");
         Button b1=new Button("Back");
          t.setLayoutX(250);
          t.setLayoutY(150);
          f.setPrefWidth(230);
          l.setLayoutY(250);
          l.setLayoutX(110);
          f.setLayoutX(220);
          f.setLayoutY(250);
          b1.setLayoutX(230);
          b1.setLayoutY(300);
         b.setLayoutX(390);
       b.setLayoutY(300);
        b.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b)
               {
                   Group g=truckcheck(sr,st,f.getText());
                   f.setText("");
                   Scene s=new Scene(g,700,700);
                   s.setFill(Color.AQUA);
                   st.setScene(s);
               }
           }
       });
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e)
           {
               if(e.getSource()==b1)
               {
                   st.setScene(r2);
                   st.show();
               }
           }
       });
       g=new Group(t,f,l,b,b1);
        return g;
        
    }
    Group custocheck(Scene sr,Stage st,String fr)
    {
        Group g=null;
        Text t=new Text("Cutomer Information");
         t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(200);
        t.setLayoutY(100);
       
        Button b=new Button("Back");
         b.setLayoutX(100);
        b.setLayoutY(620);
        TextArea a=new TextArea();
         g=new Group(a,t,b);
        a.setPrefSize(400,400);
        a.setEditable(false);
      a.setLayoutX(100);
       a.setLayoutY(200);
      new ScrollPane(a);
     
       
         try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select first,last,address,email,phone,age,pin,adhar,username,customerreg from customer";
                             
                               ResultSet rs=stt.executeQuery(s2);
                               
                               StringBuilder br=new StringBuilder();
                               
                               while(rs.next())
                               {
                                   
                                   if(rs.getString("customerreg").equals(fr))
                                   {
                                       
                                 
                                   br.append(String.format("%s%n","              ************ Customer Information ********"   ));
                                    
                                   br.append(String.format("%s","First : "+rs.getString("first")   ));
                                   br.append(String.format("%s%n","                                   Last : "+rs.getString("last")   ));
                                  
                                   br.append(String.format("%s%n","Age : "+rs.getString("age")   ));
                                   
                                   br.append(String.format("%s","Email : "+rs.getString("email")   ));
                                   br.append(String.format("%s%n","                                         Phone : "+rs.getString("phone")   ));
                                    
                                   br.append(String.format("%s","Address : "+rs.getString("address")  ));
                                   br.append(String.format("%s%n","                                      Pin : "+rs.getString("pin")   ));
                                   
                                   br.append(String.format("%s","Adhar : "+rs.getString("adhar")   ));
                                   br.append(String.format("%s%n","                                     Customer Reg : "+rs.getString("customerreg")   ));
                                  
                                   br.append(String.format("%s%n","Username : "+rs.getString("username")   ));
                                     
                                   break;
                                   }
                                   else
                                   {
                                       br=new StringBuilder();
                                       br.append(String.format("%s%n","              ************ Customer Information ********"   ));
                                        br.append(String.format("%s%n","Customer Reg : "+fr+" Does Not Exist !"   ));
                                   }
                                   
                               }
                              
                               a.setText(br.toString());
                               
                               
                }
         catch(Exception er)
         {
             
         }
         b.setOnAction(new EventHandler<ActionEvent>()
         {
             public void handle(ActionEvent e)
             {
                 if(e.getSource()==b)
                 {
                     st.setScene(r5);
                     st.show();
                 }
             }
         });
        
        return g;
        
    }
    Group carcheck(Scene sr,Stage st,String fr)
    {
        Group g=null;
        Text t=new Text("Cutomer Information");
         t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(200);
        t.setLayoutY(100);
       
        Button b=new Button("Back");
         b.setLayoutX(100);
        b.setLayoutY(620);
        TextArea a=new TextArea();
         g=new Group(a,t,b);
        a.setPrefSize(400,400);
        a.setEditable(false);
      a.setLayoutX(100);
       a.setLayoutY(200);
      new ScrollPane(a);
     
       
         try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select first,last,address,email,phone,age,pin,adhar,username,license,vehicleno,book,model,vehicle from driver where vehicle='car'";
                             PreparedStatement p=con.prepareStatement(s2);
                               ResultSet rs=p.executeQuery();
                               
                               StringBuilder br=new StringBuilder();
                               
                               while(rs.next())
                               {
                                   
                                   if(rs.getString("vehicleno").equals(fr))
                                   {
                                       System.out.println(rs.getString("vehicleno"));
                                 
                                   br.append(String.format("%s%n","              ************ Car Information ********"   ));
                                    
                                   br.append(String.format("%s","First : "+rs.getString("first")   ));
                                   br.append(String.format("%s%n","                                                    Last : "+rs.getString("last")   ));
                                  
                                   br.append(String.format("%s%n","Age : "+rs.getString("age")   ));
                                   
                                   br.append(String.format("%s","Email : "+rs.getString("email")   ));
                                   br.append(String.format("%s%n","                                         Phone : "+rs.getString("phone")   ));
                                    
                                   br.append(String.format("%s","Address : "+rs.getString("address")  ));
                                   br.append(String.format("%s%n","                                      Pin : "+rs.getString("pin")   ));
                                   
                                   br.append(String.format("%s","Adhar : "+rs.getString("adhar")   ));
                                   br.append(String.format("%s%n","                                     License : "+rs.getString("license")   ));
                                  
                                    br.append(String.format("%s","Vehicle : "+rs.getString("vehicle")   ));
                                   br.append(String.format("%s%n","                                                Vehicle NO : "+rs.getString("vehicleno")   ));
                                   
                                    br.append(String.format("%s","Model : "+rs.getString("model")   ));
                                   br.append(String.format("%s%n","                                         Booked : "+rs.getString("book")   ));
                                   
                                   br.append(String.format("%s%n","Username : "+rs.getString("username")   ));
                                     
                                   break;
                                   }
                                   else
                                   {
                                       br=new StringBuilder();
                                       br.append(String.format("%s%n","              ************ Customer Information ********"   ));
                                        br.append(String.format("%s%n","Vehicle NO : "+fr+" Does Not Exist !"   ));
                                   }
                                   
                               }
                              
                               a.setText(br.toString());
                               
                               
                }
         catch(Exception er)
         {
             
         }
         b.setOnAction(new EventHandler<ActionEvent>()
         {
             public void handle(ActionEvent e)
             {
                 if(e.getSource()==b)
                 {
                     st.setScene(r5);
                     st.show();
                 }
             }
         });
        
        return g;
        
    }
    Group truckcheck(Scene sr,Stage st,String fr)
    {
        Group g=null;
        Text t=new Text("Cutomer Information");
         t.setFont(new Font("",30));
        t.setUnderline(true);
        t.setLayoutX(200);
        t.setLayoutY(100);
       
        Button b=new Button("Back");
         b.setLayoutX(100);
        b.setLayoutY(620);
        TextArea a=new TextArea();
         g=new Group(a,t,b);
        a.setPrefSize(400,400);
        a.setEditable(false);
      a.setLayoutX(100);
       a.setLayoutY(200);
      new ScrollPane(a);
     
       
         try
                {
                String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                        
                               String s2="select first,last,address,email,phone,age,pin,adhar,username,license,vehicleno,book,model,vehicle from driver where vehicle='truck'";
                             PreparedStatement p=con.prepareStatement(s2);
                               ResultSet rs=p.executeQuery();
                               
                               StringBuilder br=new StringBuilder();
                               
                               while(rs.next())
                               {
                                   
                                   if(rs.getString("vehicleno").equals(fr))
                                   {
                                       System.out.println(rs.getString("vehicleno"));
                                 
                                   br.append(String.format("%s%n","              ************ Car Information ********"   ));
                                    
                                   br.append(String.format("%s","First : "+rs.getString("first")   ));
                                   br.append(String.format("%s%n","                                                    Last : "+rs.getString("last")   ));
                                  
                                   br.append(String.format("%s%n","Age : "+rs.getString("age")   ));
                                   
                                   br.append(String.format("%s","Email : "+rs.getString("email")   ));
                                   br.append(String.format("%s%n","                                          Phone : "+rs.getString("phone")   ));
                                    
                                   br.append(String.format("%s","Address : "+rs.getString("address")  ));
                                   br.append(String.format("%s%n","                                                 Pin : "+rs.getString("pin")   ));
                                   
                                   br.append(String.format("%s","Adhar : "+rs.getString("adhar")   ));
                                   br.append(String.format("%s%n","                                              License : "+rs.getString("license")   ));
                                  
                                    br.append(String.format("%s","Vehicle : "+rs.getString("vehicle")   ));
                                   br.append(String.format("%s%n","                                                   Vehicle NO : "+rs.getString("vehicleno")   ));
                                   
                                    br.append(String.format("%s","Model : "+rs.getString("model")   ));
                                   br.append(String.format("%s%n","                                                       Booked : "+rs.getString("book")   ));
                                   
                                   br.append(String.format("%s%n","Username : "+rs.getString("username")   ));
                                     
                                   break;
                                   }
                                   else
                                   {
                                       br=new StringBuilder();
                                       br.append(String.format("%s%n","              ************ Customer Information ********"   ));
                                        br.append(String.format("%s%n","Vehicle NO : "+fr+" Does Not Exist !"   ));
                                   }
                                   
                               }
                              
                               a.setText(br.toString());
                               
                               
                }
         catch(Exception er)
         {
             
         }
         b.setOnAction(new EventHandler<ActionEvent>()
         {
             public void handle(ActionEvent e)
             {
                 if(e.getSource()==b)
                 {
                     st.setScene(r5);
                     st.show();
                 }
             }
         });
        
        return g;
        
    }
    Group register(Scene sr,Stage st)throws Exception
    {
       Group g=null;
       PasswordField p=new PasswordField();
       TextField f=new TextField();
       Button b=new Button("submit");
       Button b1=new Button("Back");
       Text t=new Text("Register Admin");
       t.setFont(new Font("",30));
       t.setUnderline(true);
       b.setOnAction(new EventHandler<ActionEvent>()
               {
                   public void handle(ActionEvent e)
                   {
                       if(e.getSource()==b)
                       {
                           
                           try
                           {
                               String db="com.mysql.jdbc.Driver";
                               String dburl="jdbc:mysql://localhost/project";
                               String user="root";
                               String pwd="Subhojit@97";
                               Class.forName(db);
                               Connection con=DriverManager.getConnection(dburl,user,pwd);
                               Statement stt=con.createStatement();
                               String s1="insert into admin values('"+f.getText()+"','"+p.getText()+"')";
                               stt.executeUpdate(s1);
                               stt.close();
                               con.close();
                               JOptionPane.showMessageDialog(null,"Admin Registered");
                               st.setScene(r);
                   
                               st.show();
                           }
                           catch(Exception e1)
                           {
                               e1.printStackTrace();
                           }
                           
                       }
                   }
               });
       f.setPrefWidth(200);
       p.setPrefWidth(200);
       Label l=new Label("User :");
       Label l1=new Label("Password :");
       t.setLayoutX(250);
       t.setLayoutY(150);
       l1.setLayoutY(300);
       l1.setLayoutX(120);
       l.setLayoutY(200);
       l.setLayoutX(150);
       f.setLayoutX(200);
       f.setLayoutY(200);
       p.setLayoutX(200);
       p.setLayoutY(300);
       b.setLayoutX(350);
       b.setLayoutY(350);
       b1.setLayoutX(200);
       b1.setLayoutY(350);
       b1.setOnAction(new EventHandler<ActionEvent>()
       {
           public void handle(ActionEvent e1)
           {
               if(e1.getSource()==b1)
               {
                   st.setScene(r);
                   
               st.show();
               }
           }
       });
       g=new Group(f,p,b,l,l1,b1,t);
       return g;
    }
}
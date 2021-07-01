package com.eomcs.day0701;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Memo extends Frame implements WindowListener, ActionListener {
  private Button btnExit = new Button(" exit ");
  private Button btnSend = new Button(" send ");
  private TextField tf = new TextField(30);
  private TextArea ta = new TextArea();
  private Font font = new Font("consolas", Font.BOLD, 20);
  private Panel pan = new Panel();

  public Memo() {
    // 메모장 생성
    pan.add(tf);
    pan.add(btnSend);
    pan.add(btnExit);

    ta.setFont(font);
    this.add("Center", ta);
    this.add("South", pan);

    // 이벤트 연결 메서드 추가
    this.addWindowListener(this);
    tf.addActionListener(this);
    btnSend.addActionListener(this);
    btnExit.addActionListener(this);

    // 프레임의 메소드값변경
    ta.setBackground(Color.YELLOW);
    this.setSize(400, 500);
    this.setTitle("간단 메모장");
    this.setVisible(true);

  }
  @Override
  public void windowOpened(WindowEvent e) {
  }
  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(1);
  }
  @Override
  public void windowClosed(WindowEvent e) {
  }
  @Override
  public void windowIconified(WindowEvent e) {
  }
  @Override
  public void windowDeiconified(WindowEvent e) {
  }
  @Override
  public void windowActivated(WindowEvent e) {
  }
  @Override
  public void windowDeactivated(WindowEvent e) {
  }
  @Override
  public void actionPerformed(ActionEvent ae) {
    // 메뉴클릭, 버튼클릭, 이미지클릭, 입력란 enter
    if (ae.getSource() == tf) {
      myText();
    } else if (ae.getSource() == btnSend) {
      myText();
    } else if (ae.getSource() == btnExit) {
      myExit();
    } else {}
  }

  public void myText() {
    String data = tf.getText();
    ta.append(data + "\t");
    tf.setText("");
    tf.requestFocus();
  }

  public void myExit() {
    System.out.println("간단 메모장 프로그램을 종료합니다");
    System.exit(1);
  }

  public static void main(String[] args) {
    Memo pad = new Memo();
  }

}

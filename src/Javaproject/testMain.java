package Javaproject;

import java.util.Scanner;

import javax.sound.sampled.Clip;

public class testMain {
	static int coin; // ���� ���� ���� Ȯ�� ����

	public static void main(String[] args) {
		DAMADAO dama = new DAMADAO();
		DAMAVO st = new DAMAVO();
		Face fc = new Face();
		Eat eat = new Eat();
		Scanner sc = new Scanner(System.in);
		Training tr = new Training();
		Music mu = new Music();
		Adventure ad = new Adventure();
		String main_id = null;
		Event et = new Event();
		coin = 1;
		Clip bgm = mu.BattleBrothers();

		while (coin == 1) {
			int title_menu = 0; // ���������� �޴� ����
			int game_menu = -1; // ��������� �޴� ���� (1.���� 2.�Ʒ� 3.���� 4.��ħ 5.����)
			int select_menu = 0; // ���� �޴� ����
			fc.face_main();
			while (true) {
				if (title_menu == 0) {
					System.out.println();
					System.out.println("                             1. �α���       2. ȸ������        3. ��ŷȮ��       4. ���� ");
					System.out.print("                             >> ");
					title_menu = sc.nextInt();
					System.out.println();
				} else if (title_menu == 1) {
					System.out.print("���̵� �Է��ϼ��� >> ");
					String ID = sc.next();
					System.out.print("��й�ȣ �Է��ϼ��� >> ");
					String PW = sc.next();
					coin = dama.login(ID, PW);
					title_menu = 0;
					if (coin == 5) {
						main_id = ID;
						st = dama.vo_loding(main_id);
						if (st.getHp() == 0) {
							System.out.println("�̹� ���� ĳ���� �Դϴ�.");
						}else {
						break;}
					} else {
						System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���.");
					}
				} else if (title_menu == 2) {
					System.out.print("ȸ������ ���̵� �Է��ϼ��� >> ");
					String ID = sc.next();
					System.out.print("ȸ������ ��й�ȣ �Է��ϼ��� >> ");
					String PW = sc.next();
					System.out.print("�����Ͻ� �г����� �Է��ϼ��� >> ");
					String NICK = sc.next();
					System.out.print(NICK + "�� ������ �������ּ���.");
					System.out.println("[1] ���� [2] ���� [3] ������ [4] ����");
					coin = dama.join(ID, PW);
					title_menu = 0;
					if (coin == 5) {
						int job_choice = sc.nextInt();
						if (job_choice == 1) {
							System.out.println("����� �������� ���� ���� ���� �´��, �η����� �𸣴� �ο���Դϴ�.");
							System.out.println("�ٷ¿� ���� ���ʽ��� ���� ä�� �����ϸ�, �̸� ������� ���� ���������� �����ϴ� ������� ������ �ֽ��ϴ�.");
						} else if (job_choice == 2) {
							System.out.println("������ �ߺ��ϰ�, ���ں��� �������Դϴ�.");
							System.out.println("��ø�� ���� ���ʽ��� ���� ä�� �����ϸ�, �ڽ��� � ���� �ñ�� ��å�� ����մϴ�.");
						} else if (job_choice == 3) {
							System.out.println("������� ������ ��ġ�� ã�� ���ƴٴϴ� ������Դϴ�.");
							System.out.println("������ �������� �ִ� �����̸�, ������� �ڽ��� ������ ������ �������� ������ ����մϴ�.");
						} else if (job_choice == 4) {
							System.out.println("������ �̰��� �־�� �ȵǴ� �ҿ��� ���Դϴ�.");
							System.out.println("�ٸ� ������ ���ؼ� ��� Ư��� ������, �ƹ��͵� ������ ���� �ڴ� �ٸ� ������� ������ ���Դϴ�....");
						}
						dama.joinStators1(ID, NICK, job_choice);
						dama.joinStators2(ID, job_choice);
						main_id = ID;
						break;
					} else {
						System.out.println("ȸ������ ����.. �ٽ� �õ����ּ���//");
					}
				} else if (title_menu == 3) {
					dama.ranksys();
					title_menu = 0;
				} else if (title_menu == 4) {
					System.out.println("���α׷��� �����մϴ�. �ٸ���ġ����������������!!!!!!");
					coin = 0;
					break;
				} else if (title_menu == 5) {
					// ���̺� ���� �޼ҵ�
					dama.table1();
					dama.table2();
					dama.table3();
					title_menu = 0;
				} else if (title_menu == 6) {
					// ���̵� ��� Ȯ���ϴ� �޼ҵ�
					bgm.stop();
					title_menu = 0;
				} else if (title_menu == 7) {
					// ���̵� ��� Ȯ���ϴ� �޼ҵ�
					dama.all_delete();
					title_menu = 0;
				} else {
					title_menu = 0;
				}
			}

			while (coin == 5) {

				if (game_menu == -1) {
					fc.Face_Normal(main_id);
					game_menu = 0;
				} else if (game_menu == 0) {
					System.out.println("1.���� 2.�Ʒ� 3.�Ա� 4.��ħ 5.���� ");
					select_menu = sc.nextInt();
					if (select_menu == 1) {
						game_menu = 1;
					} else if (select_menu == 2) {
						game_menu = 2;
					} else if (select_menu == 3) {
						game_menu = 3;
					} else if (select_menu == 4) {
						game_menu = 4;
					} else if (select_menu == 5) {
						game_menu = 5;
					} else if (select_menu == 6) {
						game_menu = 6;
					} else {
						game_menu = 0;
					}

				} else if (game_menu == 1) {
					System.out.println("������ ������.");
					ad.select_Adven(main_id);
					st = dama.vo_loding(main_id);
					st.VO_deadly(main_id);
					st.Alldate(main_id);
					game_menu = 0;

				} else if (game_menu == 2) {
					System.out.println("�Ʒ��� ������.");
					tr.tr_Select(main_id);
					game_menu = 0;

				} else if (game_menu == 3) {
					System.out.println("�Ծ��!!");
					eat.Eat_menu(main_id);
					game_menu = 0;

				} else if (game_menu == 4) {
					System.out.println("��ħ�� �Ѵ�.");
					st.VO_sleeptry(main_id, 999, 999);
					fc.Face_Sleep(main_id);
					et.Eventset(main_id);
					game_menu = 0;

				} else if (game_menu == 5) {
					st = dama.vo_loding(main_id);
					fc.Face_Escape(main_id);
					coin = 0;
					System.out.println(" ���� ���� ");
					st.Alldate(main_id);
				} else if (game_menu == 6) {
					st = dama.vo_loding(main_id);
					fc.Face_Escape(main_id);
					coin = 1;
					System.out.println("����ȭ������");
					st.Alldate(main_id);
				}
			}
		}
		sc.close();
	}

	public void setcoin(int set) {
		coin = set;
	}

}

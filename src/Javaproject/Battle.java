package Javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	// Battle ������ ����� �ܺ� �޼ҵ带 �ҷ���.
	Face fc = new Face();
	DAMADAO dama = new DAMADAO();
	DAMAVO st;
	Enemy t;

	// �ȿ��� ����� Random�� Scanner �ҷ���.
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	Music mu = new Music();
	testMain test = new testMain();
	
	// �ܺ� ���� ����. DAMADAO�� DAMAVO���� ������ ������ �̸� ������.
	private String id;
	private String nick;
	private int lv;
	private int expe;
	private int hp;
	private int ene;
	private int maxhp;
	private int maxene;
	private int atk;
	private int spd;
	private int food;
	private int hurbs;
	private int startday;
	private int sickday;
	private int shd;
	private int str;
	private int dex;
	private int wis;
	private int luk;
	private int turnCount = 0;
	private int skill_var = 0;
	private String En_name;
	private int En_atk;
	private int En_def;
	private int En_spd;
	private int En_hp;
	private int En_str;
	private int En_dex;
	private int En_wis;
	private int En_luk;
	private int EN_turnCount = 0;
	private int dmgF;
	private int En_dmgF;

	// �� ���ݷ� ����. ���� �ӵ��� ���� ��� �� �޼ҵ� ���� ������ ������ �����ϹǷ� �̸� ������
	int En_dmg;

	// �⺻ Ȯ�� ����. basePro�� ���� �ϰ� �� �� �޼ҵ带 �и��ؼ� �ʱ�ȭ�ϹǷ�
	// ������ Ȯ���� ���� Ȯ���� �ٸ��� �����Ͽ� ���̵� ������ �� �� �ֵ��� ��
	int basePro;

	// Ȯ�� ����.
	int user_EsPro;
	int user_HitPro;
	int user_CriPro;
	int En_EsPro;
	int En_HitPro;
	int En_CriPro;
	int En_dmgR;
	
	private int user_dmg = 0;

	// DAMAVO�� Enemy���� ���� ���� ����, �� ������ �ҷ���.
	public void Anything() {

		id = st.getId();
		nick = st.getNick();
		lv = st.getLv();
		expe = st.getExpe();
		hp = st.getHp();
		ene = st.getEne();
		maxhp = st.getMaxhp();
		maxene = st.getMaxene();
		atk = st.getAtk();
		shd = st.getShd();
		spd = st.getSpd();
		str = st.getStr();
		dex = st.getDex();
		wis = st.getWis();
		luk = st.getLuk();
		food = st.getFood();
		hurbs = st.getHurbs();
		startday = st.getStartday();
		sickday = st.getSickday();
		En_name = t.getEn_name();
		En_hp = t.getEn_hp();
		En_atk = t.getEn_atk();
		En_def = t.getEn_def();
		En_spd = t.getEn_spd();
		En_str = t.getEn_str();
		En_dex = t.getEn_dex();
		En_wis = t.getEn_wis();
		En_luk = t.getEn_luk();
		// ���� ������ �⺻��

		dmgF = str+atk+(dex/2);
		if (dmgF%2 == 1) {
			dmgF = str+atk+((dex+1)/2);
		}
		user_dmg = (dmgF - En_def);
		// ���� ������ �л갪

		// �� ������ �⺻��
		En_dmgF = En_str+En_atk+(En_dex/2);
		if (En_dmgF%2 == 1) {
			En_dmgF = En_str+En_atk+((En_dex+1)/2);
		}
		En_dmg = (En_dmgF - shd);

		// �� ������ �л갪

		// ����Ȯ�� ����. Turn �޼ҵ� ������ ���� Ȯ�� ���.
		WeightsPro(user_EsPro);
		WeightsPro(user_HitPro);
		WeightsPro(user_CriPro);
		WeightsPro(En_EsPro);
		WeightsPro(En_HitPro); 
		WeightsPro(En_CriPro);

		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];
		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];

		int basePro = 50;
		user_EsPro = (basePro - 20) + (spd - En_spd);
		user_HitPro = (basePro + 30) + (dex - En_dex);
		user_CriPro = (basePro - 30) + (luk - En_luk);
		En_EsPro = basePro + (En_spd - spd);
		En_HitPro = (basePro + 20) + (En_spd - spd);
		En_CriPro = (basePro - 40) + (En_luk - luk);

	}

	// ���� �⺻ �޼ҵ�
	public void Phase(String id, int a) {

		EN_turnCount = 1;
		turnCount = 1;
		Enemy ge = new Enemy();
		st = dama.vo_loding(id);
		if (a == 1) {
			t = ge.getEnemyLand(id);
		} else if (a == 2) {
			t = ge.getEnemySea(id);
		} else if (a == 3) {
			t = ge.getEnemyAir(id);
		} else if (a ==4 ) {
			t = ge.getEnemyBoss(id);
		}

		
		Anything();

		System.out.println(t.getEn_name() + "��(��) ����� �巯�½��ϴ�.");
		System.out.println(st.getNick() + "��(��) ������ �غ��մϴ�......");
		System.out.println("");
		if (En_spd > spd + 10) {
			if (WeightsPro(En_HitPro)) {
			System.out.println(t.getEn_name() + "�� �������! " + st.getNick() + "�� " + En_dmg + "�� �������� �޾Ҵ�!");
			System.out.println("");

			hp-=En_dmg;
			}
		}
		while (true) {
			if (turnCount == 2 || EN_turnCount == 2) {
				dama.vo_update(id, st.getNick(), st.getExpe(), st.getLv(), ene, st.getMaxene(), food, hurbs, st.getStartday(),
						st.getSickday(), st.getJobid(), hp, st.getMaxhp(), st.getAtk(), st.getShd(), st.getSpd(), st.getStr(),
						st.getDex(), st.getWis(), st.getLuk(), st.getDummi());
				break;
			}
			System.out.println(t.getEn_name() + " ����// ü�� :" + En_hp + " ���ݷ� : " + En_atk + " ���� : " + En_def
					+ " �ӵ� : " + En_spd);
			System.out.println(st.getNick() + " ����// ü�� :" + hp +"������ : "+ene+ " ���ݷ� : " + atk + " ���� : " + shd + " �ӵ� : " + spd);
			System.out.println("");
			//�������� ���� �޼ҵ� �ٸ�.
			if (st.getJobid() == 1) {
				TurnWar();
			} else if (st.getJobid() == 2) {
				TurnRog();
			} else if (st.getJobid() == 3) {
				TurnWiz();
			} else if (st.getJobid() == 4) {
				TurnPoor();
			}
			if (En_hp > 0 && turnCount == 1 && skill_var != 1) {
				En_Turn();
			}
			skill_var = 0;
			if (hp < 1) {
				System.out.println("����� �׾����ϴ�.");
				st.VO_day(id, 1);
				dama.vo_update(id, st.getNick(), st.getExpe(), st.getLv(), ene, st.getMaxene(), food, hurbs, st.getStartday(),
						st.getSickday(), st.getJobid(), hp, st.getMaxhp(), st.getAtk(), st.getShd(), st.getSpd(), st.getStr(),
						st.getDex(), st.getWis(), st.getLuk(), st.getDummi());
				
				break;
			} else if (En_hp < 1) {
				
				mu.enemyDeath();
				int y = (t.getEn_hp()+t.getEn_atk()+t.getEn_def())-(t.getEn_hp()+t.getEn_atk()+t.getEn_def())%2;
				System.out.println("�̰��!" + t.getEn_name() + "�� ��ġ����!");
				System.out.println(st.getNick() + "��(��) " + y + "��ŭ�� ����ġ�� �����!");
				st.VO_experience(y, id);
				st.VO_day(id, 1);
				dama.vo_update(id, st.getNick(), st.getExpe(), st.getLv(), ene, st.getMaxene(), food, hurbs, st.getStartday(),
						st.getSickday(), st.getJobid(), hp, st.getMaxhp(), st.getAtk(), st.getShd(), st.getSpd(), st.getStr(),
						st.getDex(), st.getWis(), st.getLuk(), st.getDummi());
				
				
				if (a==4) {
					System.out.println();
					System.out.println();
					System.out.println("                  �� ������   ��Ҵ� ��");
					System.out.println();
					System.out.println();
					System.out.println("                     == ��ī�� == ");
					System.out.println("                        ������ ");
					System.out.println();
					System.out.println("                  == ���� ��Ʈ ���� == ");
					System.out.println("                        �ڼ���   ");
					System.out.println();
					System.out.println("              == ���� ���� ������ ���� ==");
					System.out.println("                        ����� ");
					System.out.println();
					System.out.println("             == ���� �ý��� ���� �� �����̳� ==");
					System.out.println("                        ������ ");
					System.out.println();
					System.out.println("               == �ٸ���ġ ü���� Ʈ���̳� ==");
					System.out.println("                  1. �迹�� 2. ������ ");
					System.out.println();
					System.out.println("               Thank you for your Play");
					System.out.println("");
					System.out.println("");
					System.out.println("Title�� ���ư��ðڽ��ϱ�?");
					System.out.println("[1] �� [2] �ƴϿ�");
					int b = sc.nextInt();
					if (b==1) {
						test.setcoin(1);
					} else if (b==2) {
						test.setcoin(5);
						fc.Face_Normal(id);
					}
				}else {
					fc.Face_Normal(id);
				}
				break;
			}

		}

	}

	// ���� �� �޼ҵ�
	public void TurnWar() {
		System.out.println(st.getNick() + "�� ��");

		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];

		int basePro = 50;
		user_EsPro = (basePro - 20) + (spd - En_spd);
		user_HitPro = (basePro + 30) + (dex - En_dex);
		user_CriPro = (basePro - 40) + (luk - En_luk);

		while (true) {

			System.out.println("[1] �����Ѵ� [2] ��ų [3] ���� �� [4] ����ģ��");
			System.out.println(" ");
			int choice = sc.nextInt();
			if (choice == 1) {
				if (user_dmgList[0] < 0) {
					user_dmgList[0] = 0;
				}
				if (user_dmgList[10] < 0) {
					user_dmgList[10] = 0;
				}
				System.out.println(
						"�����Ͻðڽ��ϱ�? ����Ȯ�� : " + user_HitPro + "%   ���� ������ : " + user_dmgList[0] + "~" + user_dmgList[10]);
				System.out.println("[1] �����Ѵ� [2] �ڷΰ���");

				int choice_attack = sc.nextInt();

				if (choice_attack == 1) {
					if (WeightsPro(user_HitPro)) {
						if (WeightsPro(user_CriPro)) {
							user_dmgR = dmgF*2;
							fc.Face_Cri(id);
							mu.Bloody();
							mu.ASingularStrike();
							System.out.println("ũ��Ƽ��! " + En_name + "�� " + user_dmgR + "�� �������� �޾Ҵ�! ");
							System.out.println(st.getNick() + " : '����� ����.'");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						} else {
							fc.Face_Fight(id);
							mu.Bloody();
							if (user_dmgR < 0) {
								user_dmgR = 0;
							}
							System.out
									.println(st.getNick() + "�� ������! " + En_name + "��(��) " + user_dmgR + "�� �������� �޾Ҵ�!");
							System.out.println("");
							En_hp -= user_dmgR;

							break;
						}
					} else {
						mu.AirCut();
						fc.Face_Miss(id);
						System.out.println(En_name + " ȸ��! " + st.getNick() + "��(��) �ƹ��� ���ص� ������ ���ߴ�!");
						System.out.println("");
						break;
					}

				}

			}

			else if (choice == 2) {

				System.out.println("[1] ���� [2] ����  [3] ���ʸԱ� [4] �ڷΰ���");
				System.out.println("");
				int choice_skill = sc.nextInt();
				if (choice_skill == 1) {
					if (ene <= 30) {
						System.out.println("�������� ����!" + st.getNick() + "��(��) ���Ǹ� ���� �� ������!");
						System.out.println("");
					} else {
						fc.Face_De(id);
						mu.Determination();
						ene -= 10;
						shd += 5;
						str += 5;
						System.out.println(st.getNick() + "��(��) ���� ������ �ǻ���� ���Ǹ� ������. ���°� �ٷ��� 5��ŭ �����ߴ�.");
						System.out.println(st.getNick() + " : '�� ������ �ƹ��͵� �ƴϾ�.'");
						System.out.println("");
						break;
					}
				} else if (choice_skill == 2) {
					int a = 20;

					if (hp <= 20) {
						System.out.println(st.getNick() + " : '�ٸ� ����� ����. ��. ��� �غ��ڰ�.'");
					}

					int charge_dmg = (atk * str * shd) / 20;
					if ((charge_dmg) % 2 == 1) {
						charge_dmg = (atk * str * shd + 1) / 20;
					}
					mu.warcry();
					System.out.println(st.getNick() + "�� ����! " + En_name + "��(��) " + charge_dmg + "�� �������� �޾Ҵ�!");
					System.out.println("�׷���" + st.getNick() + " ���� " + a + "�� ü���� �Ҹ��ߴ�!");
					System.out.println("");
					En_hp -= charge_dmg;
					hp -= a;
					break;

				} else if (choice_skill == 3) {
					if (hurbs < 1) {
						System.out.println("���ʰ� ����! ȸ���� �Ұ����ϴ�!");
						System.out.println(st.getNick() + " : '����! �̷� �� �˾����� �� ���س��� �ǵ�!'");
						System.out.println("");
					} else {
						mu.Heal();
						hp += 100;
						hurbs--;
						if (hp > maxhp) {
							hp = maxhp;
						}
						System.out.println(st.getNick() + "��(��) ���ʸ� ����Ͽ� ü���� ȸ���ߴ�! 20��ŭ ü���� ȸ���Ǿ���!");
						System.out.println("");
						break;
					}
				}

			} else if (choice == 3) {
				StatusShow();
			}

			else if (choice == 4) {
				System.out.println("����ġ�ðڽ��ϱ�? Ż��Ȯ�� : " + user_EsPro + "%");
				System.out.println("[1] �� [2] �ƴϿ�");
				int choice_Escape = sc.nextInt();
				if (choice_Escape == 1) {
					if (WeightsPro(user_EsPro)) {
						fc.Face_Escape(id);
						System.out.println(st.getNick() + "��(��) ������ó�� ��������!");
						System.out.println("");
						turnCount = 2;
						break;
					}

					else {
						if (En_dmgR < 0) {
							En_dmgR = 0;
						}
						System.out.println(st.getNick() + "��(��) ����ĥ �� ������! " + En_dmgR + "�� �������� �޾Ҵ�!");
						System.out.println("");
						if (shd >= En_dmg) {
							En_dmg = 0;
						}
						hp -= En_dmgR;
						break;
					}
				}
			}
		}
	}

	public void TurnRog() {

		System.out.println(st.getNick() + "�� ��");

		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];

		int basePro = 50;

		while (true) {

			System.out.println("[1] �����Ѵ� [2] ��ų [3] ���� �� [4] ����ģ��");
			System.out.println(" ");
			int choice = sc.nextInt();
			if (choice == 1) {
				if (user_dmgList[0] < 0) {
					user_dmgList[0] = 0;
				}
				if (user_dmgList[10] < 0) {
					user_dmgList[10] = 0;
				}
				System.out.println(
						"�����Ͻðڽ��ϱ�? ����Ȯ�� : " + user_HitPro + "%   ���� ������ : " + user_dmgList[0] + "~" + user_dmgList[10]);
				System.out.println("[1] �����Ѵ� [2] �ڷΰ���");

				int choice_attack = sc.nextInt();

				if (choice_attack == 1) {
					if (WeightsPro(user_HitPro)) {
						if (WeightsPro(user_CriPro)) {
							user_dmgR = dmgF*2;
							fc.Face_Cri(id);
							mu.Bloody();
							mu.ASingularStrike();
							System.out.println("ũ��Ƽ��! " + En_name + "�� " + user_dmgR + "�� �������� �޾Ҵ�! ");
							System.out.println(st.getNick() + " : '<���Ķ� �Ҹ�>'");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						} else {
							fc.Face_Fight(id);
							mu.Bloody();
							if (user_dmgR < 0) {
								user_dmgR = 0;
							}
							System.out
									.println(st.getNick() + "�� ���! " + En_name + "��(��) " + user_dmgR + "�� �������� �޾Ҵ�!");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						}
					} else {
						mu.AirCut();
						fc.Face_Miss(id);
						System.out.println(En_name + " ȸ��! " + st.getNick() + "��(��) �ƹ��� ���ص� ������ ���ߴ�!");
						System.out.println("");
						break;
					}

				}

			}

			else if (choice == 2) {

				System.out.println("[1] ������ �� [2] ���� ���  [3] ���ʸԱ� [4] �ڷΰ���");
				System.out.println("");
				int choice_skill = sc.nextInt();
				if (choice_skill == 1) {
					if (ene <= 20) {
						System.out.println("�������� ����!" + st.getNick() + "�� ������ ���� �ߵ��� �� ������.");
						System.out.println("");
					}
					fc.Face_De(id);
					mu.Determination();
					dex += 5;
					
					ene -= 20;
					System.out.println(st.getNick() + "�� ���������� ��븦 �ľ��ߴ�. ��ø�� 5 ����ߴ�.");
					break;

				} else if (choice_skill == 2) {
					int a = 30;
					if (ene <= 30) {
						System.out.println(st.getNick() + " : '����� ��� ������ �ȵ�...'");
						break;
					}

					int shoot_dmg = (atk * dex) / 3;
					if (shoot_dmg == 1) {
						shoot_dmg = (atk * dex + 1) / 3;
					}
					fc.Face_Gun(id);
					ene -= 30;
					System.out.println(st.getNick() + "�� ���� ���! " + En_name + "��(��) " + shoot_dmg + "�� �������� �޾Ҵ�!");
					System.out.println(st.getNick() + " : '���ƿ��°� ���ñ���. �׷���?'");
					System.out.println("");
					En_hp -= shoot_dmg;
					skill_var = 1;
					mu.gunshot1();
					break;

				} else if (choice_skill == 3) {
					if (hurbs < 1) {
						System.out.println("���ʰ� ����! ȸ���� �Ұ����ϴ�!");
						System.out.println(st.getNick() + " : '����! �̷� �� �˾����� �� ���س��� �ǵ�!'");
						System.out.println("");
					} else {
						hp += 100;
						hurbs--;
						if (hp > maxhp) {
							hp = maxhp;
						}
						mu.Heal();
						System.out.println(st.getNick() + "��(��) ���ʸ� ����Ͽ� ü���� ȸ���ߴ�! 20��ŭ ü���� ȸ���Ǿ���!");
						System.out.println("");
						break;

					}
				}

			} else if (choice == 3) {
				StatusShow();
			}

			else if (choice == 4) {
				System.out.println("����ġ�ðڽ��ϱ�? Ż��Ȯ�� : " + user_EsPro + "%");
				System.out.println("[1] �� [2] �ƴϿ�");
				int choice_Escape = sc.nextInt();
				if (choice_Escape == 1) {
					if (WeightsPro(user_EsPro)) {
						fc.Face_Escape(id);
						System.out.println(st.getNick() + "��(��) ������ó�� ��������!");
						System.out.println("");
						turnCount = 2;
						break;
					}

					else {
						if (En_dmgR < 0) {
							En_dmgR = 0;
						}
						System.out.println(st.getNick() + "��(��) ����ĥ �� ������! " + En_dmgR + "�� �������� �޾Ҵ�!");
						System.out.println("");
						if (shd >= En_dmg) {
							En_dmg = 0;
						}
						hp -= En_dmgR;
						break;
					}
				}
			}
		}
	}

	public void TurnWiz() {

		System.out.println(st.getNick() + "�� ��");

		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];

		int basePro = 50;
		user_EsPro = (basePro - 20) + (spd - En_spd);
		user_HitPro = (basePro + 30) + (dex - En_dex);
		user_CriPro = (basePro - 40) + (luk - En_luk);

		while (true) {

			System.out.println("[1] �����Ѵ� [2] ��ų [3] ���� �� [4] ����ģ��");
			System.out.println(" ");
			int choice = sc.nextInt();
			if (choice == 1) {
				if (user_dmgList[0] < 0) {
					user_dmgList[0] = 0;
				}
				if (user_dmgList[10] < 0) {
					user_dmgList[10] = 0;
				}
				System.out.println(
						"�����Ͻðڽ��ϱ�? ����Ȯ�� : " + user_HitPro + "%   ���� ������ : " + user_dmgList[0] + "~" + user_dmgList[10]);
				System.out.println("[1] �����Ѵ� [2] �ڷΰ���");

				int choice_attack = sc.nextInt();

				if (choice_attack == 1) {
					if (WeightsPro(user_HitPro)) {
						if (WeightsPro(user_CriPro)) {
							user_dmgR = dmgF*2;
							fc.Face_Cri(id);
							mu.Bloody();
							mu.ASingularStrike();
							System.out.println("ũ��Ƽ��! " + En_name + "�� " + user_dmgR + "�� �������� �޾Ҵ�! ");
							System.out.println(st.getNick() + ": '��. �������� å��Ӹ����� �ɾ��ִ� �� �ƴϰŵ�?'");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						} else {
							fc.Face_Fight(id);
							mu.Bloody();
							if (user_dmgR < 0) {
								user_dmgR = 0;
							}
							System.out.println(
									st.getNick() + "�� ������ �ֵθ���! " + En_name + "��(��) " + user_dmgR + "�� �������� �޾Ҵ�!");
							System.out.println(st.getNick() + ": '�� ��������! �� ����� ��� ������ ���ΰ� �߸���ó�� �ο�� �ִ°���?'");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						}
					} else {
						mu.AirCut();
						fc.Face_Miss(id);
						System.out.println(En_name + " ȸ��! " + st.getNick() + "��(��) �ƹ��� ���ص� ������ ���ߴ�!");
						System.out.println("");
						break;
					}

				}

			}

			else if (choice == 2) {

				System.out.println("[1] ���̾ [2] ���̽� ���Ǿ�  [3] ���ʸԱ� [4] �ڷΰ���");
				System.out.println("");
				int choice_skill = sc.nextInt();
				if (choice_skill == 1) {
					if (ene <= 30) {
						System.out.println("�������� ����! ���� ���̾�� ���� �� �����ϴ�!");
						System.out.println("");
					} else {
						int fire_dmg = (atk * wis) / 2;
						if ((atk * wis) % 2 == 1) {
							fire_dmg = (atk * wis + 1) / 2;
						}
						ene -= 30;
						fc.Face_Fire(id);
						System.out.println(
								st.getNick() + "�� ���̾�� �����ߴ�! " + En_name + "��(��) �ұ濡 �۽ο�" + fire_dmg + "�� �������� �޾Ҵ�!");
						System.out.println("");
						En_hp -= fire_dmg;
						skill_var = 1;
						mu.Fireball();
						break;
					}
				} else if (choice_skill == 2) {
					if (ene <= 30) {
						System.out.println("�������� ����! ���� ���̽� ���Ǿ ���� �� �����ϴ�!");
						System.out.println("");
					} else {
						int ice_dmg = (atk * wis) / 2;
						if ((atk * wis) % 2 == 1) {
							ice_dmg = (atk * wis + 1) / 2;
						}
						ene -= 10;
						fc.Face_Fire(id);
						System.out.println(st.getNick() + "�� ���̽� ���Ǿ�! " + En_name + "��(��) " + ice_dmg + "�� �������� �޾Ҵ�!");
						System.out.println("");
						En_hp -= ice_dmg;
						mu.ice();
						break;
					}
				} else if (choice_skill == 3) {
					if (hurbs < 1) {
						System.out.println("���ʰ� ����! ȸ���� �Ұ����ϴ�!");
						System.out.println(st.getNick() + " : '����! �̷� �� �˾����� �� ���س��� �ǵ�!'");
						System.out.println("");
					} else {
						hp += 100;
						hurbs--;
						if (hp > maxhp) {
							hp = maxhp;
						}
						mu.Heal();
						System.out.println(st.getNick() + "��(��) ���ʸ� ����Ͽ� ü���� ȸ���ߴ�! 20��ŭ ü���� ȸ���Ǿ���!");
						System.out.println("");
						break;
					}
				}

			} else if (choice == 3) {
				StatusShow();
			}

			else if (choice == 4) {
				System.out.println("����ġ�ðڽ��ϱ�? Ż��Ȯ�� : " + user_EsPro + "%");
				System.out.println("[1] �� [2] �ƴϿ�");
				int choice_Escape = sc.nextInt();
				if (choice_Escape == 1) {
					if (WeightsPro(user_EsPro)) {
						fc.Face_Escape(id);
						System.out.println(st.getNick() + "��(��) ������ó�� ��������!");
						System.out.println("");
						turnCount = 2;
						break;
					}

					else {
						if (En_dmgR < 0) {
							En_dmgR = 0;
						}
						System.out.println(st.getNick() + "��(��) ����ĥ �� ������! " + En_dmgR + "�� �������� �޾Ҵ�!");
						System.out.println("");
						if (shd >= En_dmg) {
							En_dmg = 0;
						}
						hp -= En_dmgR;
						break;
					}
				}
			}
		}
	}

	public void TurnPoor() {
		System.out.println(st.getNick() + "�� ��");
		int[] user_dmgList = { user_dmg - 5, user_dmg - 4, user_dmg - 3, user_dmg - 2, user_dmg - 1, user_dmg,
				user_dmg + 1, user_dmg + 2, user_dmg + 3, user_dmg + 4, user_dmg + 5 };
		int user_dmgDev = rd.nextInt(10);
		int user_dmgR = user_dmgList[user_dmgDev];
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];

		int basePro = 50;
		user_EsPro = (basePro - 20) + (spd - En_spd);
		user_HitPro = (basePro + 30) + (dex - En_dex);
		user_CriPro = (basePro - 40) + (luk - En_luk);

		while (true) {

			System.out.println("[1] �����Ѵ� [2] ��ų [3] ���� �� [4] ����ģ��");
			System.out.println(" ");
			int choice = sc.nextInt();
			if (choice == 1) {
				if (user_dmgList[0] < 0) {
					user_dmgList[0] = 0;
				}
				System.out.println(
						"�����Ͻðڽ��ϱ�? ����Ȯ�� : " + user_HitPro + "%   ���� ������ : " + user_dmgList[0] + "~" + user_dmgList[10]);
				System.out.println("[1] �����Ѵ� [2] �ڷΰ���");

				int choice_attack = sc.nextInt();

				if (choice_attack == 1) {
					if (WeightsPro(user_HitPro)) {
						if (WeightsPro(user_CriPro)) {
							user_dmgR = dmgF;
							fc.Face_Cri(id);
							mu.Bloody();
							mu.ASingularStrike();
							System.out.println("ũ��Ƽ��! " + En_name + "�� " + user_dmgR + "�� �������� �޾Ҵ�! ");
							System.out.println(st.getNick() + " : '����߱���. �׷���?'");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						} else {
							fc.Face_Fight(id);
							mu.Bloody();
							if (user_dmgR < 0) {
								user_dmgR = 0;
							}
							System.out.println(st.getNick() + "�� ��ġ! " + En_name + "��(��) " + user_dmgR + "�� �������� �޾Ҵ�!");
							System.out.println("");
							En_hp -= user_dmgR;
							break;
						}
					} else {
						mu.AirCut();
						fc.Face_Miss(id);
						System.out.println(En_name + " ȸ��! " + st.getNick() + "��(��) �ƹ��� ���ص� ������ ���ߴ�!");
						System.out.println("");
						break;
					}

				}

			}

			else if (choice == 2) {

				System.out.println("[1] ���� [2] ����  [3] ������ �� [4] ���� ��� [5] ���̾ [6] ���̽� ���Ǿ� [7] ���ʸԱ� [8] �ڷΰ���");
				System.out.println(" ");
				int choice_skill = sc.nextInt();
				if (choice_skill == 1) {
					if (ene <= 30) {
						System.out.println("�������� ����!" + st.getNick() + "��(��) ���Ǹ� ���� �� ������!");
						System.out.println("");
					} else {
						ene -= 15;
						shd += 5;
						str += 5;
						fc.Face_De(id);
						mu.Determination();
						System.out.println(st.getNick() + "��(��) ���� ������ �ǻ���� ���Ǹ� ������. ���°� �ٷ��� 5��ŭ �����ߴ�.");
						System.out.println(st.getNick() + " : '�� ������ �ƹ��͵� �ƴϾ�.'");
						System.out.println("");
						break;
					}
				} else if (choice_skill == 2) {
					int a = 30;

					if (hp <= 30) {
						System.out.println(st.getNick() + " : '�ٸ� ����� ����. ��. ��� �غ��ڰ�.'");
					}

					int charge_dmg = (atk * str * shd) / 10;
					if ((charge_dmg) % 2 == 1) {
						charge_dmg = (atk * str * shd + 1) / 10;
					}
					mu.warcry();
					System.out.println(st.getNick() + "�� ����! " + En_name + "��(��) " + charge_dmg + "�� �������� �޾Ҵ�!");
					System.out.println("�׷���" + st.getNick() + " ���� " + a + "�� ü���� �Ҹ��ߴ�!");
					System.out.println("");
					En_hp -= charge_dmg;
					hp -= a;
					break;

				} else if (choice_skill == 3) {
					if (ene <= 30) {
						System.out.println("�������� ����!" + st.getNick() + "�� ������ ���� �ߵ��� �� ������.");
						System.out.println("");
					}
					dex += 5;
					mu.Determination();
					fc.Face_De(id);
					System.out.println(st.getNick() + "�� ���������� ��븦 �ľ��ߴ�. ��ø�� 5 ����ߴ�.");
					break;

				} else if (choice_skill == 4) {
					int a = 30;
					if (ene <= 30) {
						System.out.println(st.getNick() + " : '����� ��� ������ �ȵ�...'");
						break;
					}

					int shoot_dmg = (atk * dex) / 3;
					if (shoot_dmg == 1) {
						shoot_dmg = (atk * dex + 1) / 3;
					}
					ene -= 10;
					mu.gunshot1();
					fc.Face_Gun(id);
					System.out.println(st.getNick() + "�� ���� ���! " + En_name + "��(��) " + shoot_dmg + "�� �������� �޾Ҵ�!");
					System.out.println(st.getNick() + " : '���ƿ��°� ���ñ���. �׷���?'");
					System.out.println("");
					En_hp -= shoot_dmg;
					skill_var = 1;

					break;

				} else if (choice_skill == 5) {
					if (ene <= 30) {
						System.out.println("�������� ����! ���� ���̾�� ���� �� �����ϴ�!");
						System.out.println("");
					} else {
						int fire_dmg = (atk * wis) / 2;
						if ((atk * wis) % 2 == 1) {
							fire_dmg = (atk * wis + 1) / 2;
						}
						ene -= 20;
						mu.Fireball();
						fc.Face_Fire(id);
						System.out.println(
								st.getNick() + "�� ���̾�� �����ߴ�! " + En_name + "��(��) �ұ濡 �۽ο�" + fire_dmg + "�� �������� �޾Ҵ�!");
						System.out.println("");
						En_hp -= fire_dmg;
						skill_var = 1;
						break;
					}
				} else if (choice_skill == 6) {
					if (ene <= 10) {
						System.out.println("�������� ����! ���� ���̽� ���Ǿ ���� �� �����ϴ�!");
						System.out.println("");
					} else {
						int ice_dmg = (atk * wis) / 2;
						if ((atk * wis) % 2 == 1) {
							ice_dmg = (atk * wis + 1) / 2;
						}
						ene -= 10;
						mu.ice();
						fc.Face_Fire(id);
						System.out.println(st.getNick() + "�� ���̽� ���Ǿ�! " + En_name + "��(��) " + ice_dmg + "�� �������� �޾Ҵ�!");
						System.out.println("");
						En_hp -= ice_dmg;
						break;
					}
				}

				else if (choice_skill == 7) {
					if (hurbs < 1) {
						System.out.println("���ʰ� ����! ȸ���� �Ұ����ϴ�!");
						System.out.println(st.getNick() + " : '����! �̷� �� �˾����� �� ���س��� �ǵ�!'");
						System.out.println("");
					} else {
						hp += 100;
						hurbs--;
						if (hp > maxhp) {
							hp = maxhp;
						}
						mu.Heal();
						System.out.println(st.getNick() + "��(��) ���ʸ� ����Ͽ� ü���� ȸ���ߴ�! 20��ŭ ü���� ȸ���Ǿ���!");
						System.out.println("");
						break;
					}
				}

			} else if (choice == 3) {
				StatusShow();
			}

			else if (choice == 4) {
				System.out.println("����ġ�ðڽ��ϱ�? Ż��Ȯ�� : " + user_EsPro + "%");
				System.out.println("[1] �� [2] �ƴϿ�");
				int choice_Escape = sc.nextInt();
				if (choice_Escape == 1) {
					if (WeightsPro(user_EsPro)) {
						fc.Face_Escape(id);
						System.out.println(st.getNick() + "��(��) ������ó�� ��������!");
						System.out.println("");
						turnCount = 2;
						break;
					}

					else {
						if (En_dmgR < 0) {
							En_dmgR = 0;
						}
						System.out.println(st.getNick() + "��(��) ����ĥ �� ������! " + En_dmgR + "�� �������� �޾Ҵ�!");
						System.out.println("");
						if (shd >= En_dmg) {
							En_dmg = 0;
						}
						hp -= En_dmgR;
						break;
					}
				}
			}
		}
	}

	// �� �� �޼ҵ�
	public void En_Turn() {

		System.out.println(t.getEn_name() + "�� ��");

		if (En_hp < user_dmg && En_EsPro < 50) {
			if (WeightsPro(En_EsPro)) {
				System.out.println(En_name + "��(��) �����ƴ�!");
				EN_turnCount = 2;
			} else {
				En_Attack();
			}

		} else {
			En_Attack();
		}
	}

	// ���� Ȯ�� ����� �޼ҵ�
	public static boolean WeightsPro(int percentNum) {

		boolean result = false;

		List<Integer> arrPick = getScopeList(1, 100);
		int pickNum = getRandom(1, 100); // �����, 1 ~ 100�� ������ ��1(�� ���ڰ� Ȯ���迭�� ���Կ��� üũ)

		if (0 < percentNum && percentNum < 100) {
			Collections.shuffle(arrPick);
			for (int i = 1; i <= percentNum; i++) {

				if (arrPick.get(i - 1) == pickNum) {
					result = true;
					break;
				}
			}
		} else if (percentNum >= 100) {

			result = true;
		}
		return result;
	}

	public static List<Integer> getScopeList(int pstart, int pend) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = pstart; i <= pend; i++) {

			list.add(i);
		}
		return list;
	}

	public static int getRandom(int p_start, int p_end) {

		Random rnd = new Random();

		if (p_start >= p_end) {

			return 0;

		} else {

			return rnd.nextInt(p_end - p_start + 1) + p_start;
		}

	}

	// �� �� �˰���
	public void En_Attack() {

		int En_dmg = (En_str + En_atk - shd);
		int[] En_dmgList = { En_dmg - 5, En_dmg - 4, En_dmg - 3, En_dmg - 2, En_dmg - 1, En_dmg, En_dmg + 1, En_dmg + 2,
				En_dmg + 3, En_dmg + 4, En_dmg + 5 };
		int En_dmgDev = rd.nextInt(10);
		int En_dmgR = En_dmgList[En_dmgDev];
		int basePro = 50;
		int En_EsPro = basePro + (En_spd - spd);
		int En_HitPro = (basePro + 20) + (En_spd - spd);
		int En_CriPro = (basePro - 40) + (En_luk - luk);

		if (WeightsPro(En_HitPro)) {
			if (WeightsPro(En_CriPro)) {
				En_dmgR = En_dmgF;
				fc.Face_Cri(id);
				System.out.println(En_name + "�� ġ������ ����! " + st.getNick() + "��(��)" + En_dmgR + "�� �������� �޾Ҵ�!");
				System.out.println("");
				hp -= En_dmgR;
			} else {
				if (En_dmgR < 0) {
					En_dmgR = 0;
				}
				fc.Face_Fight(id);
				System.out.println(En_name + "�� ����! " + st.getNick() + "��(��)" + En_dmgR + "�� �������� �޾Ҵ�!");
				System.out.println("");
				hp -= En_dmgR;

			}
		} else {
			fc.Face_Miss(id);
			System.out.println(st.getNick() + "�� ����� ȸ��! " + En_name + "��(��) ��� ���ص� ������ ���ߴ�!");
			System.out.println("");
		}

	}

	// ���� ���˿� �޼ҵ�
	public void checkUserValues() {
		System.out.println("����" + lv);
		System.out.println("����ġ" + expe);
		System.out.println("ü��" + hp);
		System.out.println("������" + ene);
		System.out.println("�ִ�ü��" + maxhp);
		System.out.println("�ִ뿡����" + maxene);
		System.out.println("���ݷ�" + atk);
		System.out.println("�ӵ�" + spd);
		System.out.println("����" + food);
		System.out.println("����" + hurbs);
		System.out.println("����" + shd);
		System.out.println("��" + str);
		System.out.println("��" + dex);
		System.out.println("��" + wis);
		System.out.println("��" + luk);
		System.out.println("Ż��Ȯ��" + user_EsPro);
		System.out.println("ġ����" + user_CriPro);
		System.out.println("���߷�" + user_HitPro);
	}

	public void checkEnValues() {
		System.out.println("��ü��" + En_hp);
		System.out.println("�����ݷ�" + En_atk);
		System.out.println("���ӵ�" + En_spd);
		System.out.println("������" + En_def);
		System.out.println("����" + En_str);
		System.out.println("����" + En_dex);
		System.out.println("����" + En_wis);
		System.out.println("����" + En_luk);
		System.out.println("��Ż��Ȯ��" + En_EsPro);
		System.out.println("�����߷�" + En_HitPro);
		System.out.println("��ġ����" + En_CriPro);
	}

	public void StatusShow() {
		System.out.println(st.getId() + "                        " + t.getEn_name());
		System.out.println("ü�� : " + hp + "/" + maxhp + "                   " + En_hp + "/" + t.getEn_hp());
		System.out.println("������ : " + ene + "/" + maxene + "                 ");
		System.out.println("���� : " + food + "                       ");
		System.out.println("���� : " + hurbs + "                       ");

		System.out.println("���ݷ� : " + atk + "                        " + En_atk);
		System.out.println("�ӵ� : " + spd + "                         " + En_spd);
		System.out.println("���� : " + shd + "                         " + En_def);
		System.out.println("�� : " + str + "                           " + En_str);
		System.out.println("�� : " + dex + "                           " + En_dex);
		System.out.println("�� : " + wis + "                           " + En_wis);
		System.out.println("�� : " + luk + "                           " + En_luk);
		System.out.println("Ż��Ȯ�� : " + user_EsPro + "%                     " + En_EsPro + "%");
		System.out.println("ġ���� : " + user_CriPro + "%                       " + En_CriPro + "%");
		System.out.println("���߷� : " + user_HitPro + "%                      " + En_HitPro + "%");
	}
}

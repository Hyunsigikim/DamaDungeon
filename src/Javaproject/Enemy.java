package Javaproject;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

	DAMADAO dama = new DAMADAO();
	DAMAVO st = new DAMAVO();
	Face fc = new Face();

	private String id;
	private int maxhp;
	private int atk;
	private int spd;
	private int shd;
	private int str;
	private int dex;
	private int wis;
	private int luk;

	// �� ���� ����
	private String En_name;
	private int En_hp;
	private int En_atk;
	private int En_def;
	private int En_spd;
	private int En_str;
	private int En_dex;
	private int En_wis;
	private int En_luk;
	private int t;

	Random rd = new Random();

	public Enemy() {
	}

	public String getEn_name() {
		return En_name;
	}

	public int getEn_hp() {
		return En_hp;
	}

	public int getEn_atk() {
		return En_atk;
	}

	public int getEn_def() {
		return En_def;
	}

	public int getEn_spd() {
		return En_spd;
	}

	public void setEn_name(String en_name) {
		En_name = en_name;
	}

	public void setEn_hp(int en_hp) {
		En_hp = en_hp;
	}

	public void setEn_atk(int en_atk) {
		En_atk = en_atk;
	}

	public void setEn_def(int en_def) {
		En_def = en_def;
	}

	public void setEn_spd(int en_spd) {
		En_spd = en_spd;
	}

	public int getEn_str() {
		return En_str;
	}

	public void setEn_str(int en_str) {
		En_str = en_str;
	}

	public int getEn_dex() {
		return En_dex;
	}

	public void setEn_dex(int en_dex) {
		En_dex = en_dex;
	}

	public int getEn_wis() {
		return En_wis;
	}

	public void setEn_wis(int en_wis) {
		En_wis = en_wis;
	}

	public int getEn_luk() {
		return En_luk;
	}

	public void setEn_luk(int en_luk) {
		En_luk = en_luk;
	}

	public Enemy getEnemyLand(String id) {

		st = dama.vo_loding(id);

		int a = (rd.nextInt(8) * 10);
		int b = rd.nextInt(8);
		int c = rd.nextInt(8);
		int d = rd.nextInt(8);
		int e = rd.nextInt(8);
		int f = rd.nextInt(8);
		int g = rd.nextInt(8);
		int h = rd.nextInt(8);

		UserInfo();

		int t = 5 + st.getStartday();
		int z = 5 + (st.getStartday() * 10);
		ArrayList<Enemy> eList = new ArrayList<>();

		// eList.add(new Enemy("�䳢", 1, 1, 1, 1, 1,1,1,1));
		eList.add(new Enemy("�䳢", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�罿", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�ݴް�����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��ũ", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�˵���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�����ú�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�ھ˶�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("Ļ�ŷ�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("������ī�ڳ���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("ȣ����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("ġŸ", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("ǥ��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��踻", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���̿���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		int i = rd.nextInt(eList.size() - 1);
		System.out.println(i);
		return eList.get(i);

	}

	public Enemy getEnemySea(String id) {

		st = dama.vo_loding(id);
		int a = (rd.nextInt(8) * 10);
		int b = rd.nextInt(8);
		int c = rd.nextInt(8);
		int d = rd.nextInt(8);
		int e = rd.nextInt(8);
		int f = rd.nextInt(8);
		int g = rd.nextInt(8);
		int h = rd.nextInt(8);

		UserInfo();

		int t = 10 + st.getStartday();
		int z = 10 + (st.getStartday() * 10);

		ArrayList<Enemy> eList = new ArrayList<>();

		eList.add(new Enemy("�۾�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��ġ", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��ġ", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��ġ", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��ġ", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("û��Ƹ�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���Ƹ�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("ö�����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("Ȥ���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���ؾ�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���α�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�Ʊ���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�ź���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�ٴ�ǥ��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		int i = rd.nextInt(eList.size() - 1);
		System.out.println(i);
		return eList.get(i);

	}

	public Enemy getEnemyAir(String id) {

		st = dama.vo_loding(id);

		int a = (rd.nextInt(8) * 10);
		int b = rd.nextInt(8);
		int c = rd.nextInt(8);
		int d = rd.nextInt(8);
		int e = rd.nextInt(8);
		int f = rd.nextInt(8);
		int g = rd.nextInt(8);
		int h = rd.nextInt(8);

		UserInfo();

		int t = 15 + st.getStartday();
		int z = 15 + (st.getStartday() * 10);
		ArrayList<Enemy> eList = new ArrayList<>();
		eList.add(new Enemy("�յ�����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��Ӹ�������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("Ÿ��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�ϴðź���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��ī������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�ĸ�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���ڸ�", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("����", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d), randomCal(t, e),
				randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("ȣ������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("��½��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("�η��", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("���ڱ���", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("Ȳ������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		eList.add(new Enemy("������", randomCalHp(z, a), randomCal(t, b), randomCal(t, c), randomCal(t, d),
				randomCal(t, e), randomCal(t, f), randomCal(t, g), randomCal(t, 1)));
		int i = rd.nextInt(eList.size() - 1);
		System.out.println(i);
		return eList.get(i);

	}

	public Enemy getEnemyBoss(String id) {

		int t = 20 + st.getStartday();
		int z = 20 + (st.getStartday() * 10);

		st = dama.vo_loding(id);
		UserInfo();

		System.out.println("�� ������ ������ �� " + st.getStartday() + "���� ������." + st.getNick() + "��(��) ���ݲ� �ο��� ������ �����ߴ�.");
		System.out.println("'�� ��� �ο���, ���� �� ������ ���� ���̴�.' " + st.getNick() + "��(��) �����ߴ�.");
		System.out.println(st.getNick() + " : '��� ���� ������ ��������. ������ ������ �� ���� �� �� ���� ��.'");
		System.out.println(st.getNick() + "��(��) ������ ������ �غ��ߴ�.");
		System.out.println("");

		fc.Face_Boss(id);

		return new Enemy("�ڹ�", 1000, 60, 60, 60, 60, 60, 60, 60);
	}

	public Enemy(String en_name, int en_hp, int en_atk, int en_def, int en_spd, int en_str, int en_dex, int en_wis,
			int en_luk) {
		En_name = en_name;
		En_hp = en_hp;
		En_atk = en_atk;
		En_def = en_def;
		En_spd = en_spd;
		En_str = en_str;
		En_dex = en_dex;
		En_wis = en_wis;
		En_luk = en_luk;
	}

	public void UserInfo() {
		id = st.getId();
		maxhp = st.getMaxhp();
		atk = st.getAtk();
		shd = st.getShd();
		spd = st.getSpd();
		str = st.getStr();
		dex = st.getDex();
		wis = st.getWis();
		luk = st.getLuk();

	}

	public int randomCal(int a, int b) {
		int t = rd.nextInt(2);
		int result;
		if (t == 0) {
			result = a + b;
		} else {
			result = a - b;
		}
		return result;

	}

	public int randomCalHp(int a, int b) {
		int result;
		result = a + b;

		return result;

	}

}
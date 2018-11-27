
public class MaxProfitTest {
	public static void main(String[] args) {
		//��������
		int[] prices= {7,6,5,4,3,2};
		//
		System.out.println(maxProfit(prices));
		
	}
	public static int maxProfit(int[] prices) {
		int income=0;
		int buy=Integer.MAX_VALUE;
		
		for(int price:prices) {
			buy=buy<=price?buy:price;//�ҵ���С�����
			income=income>(price-buy)?income:(price-buy);//�Ƚϵ�ǰʱ����������
		}
		return income;
	}
	
}

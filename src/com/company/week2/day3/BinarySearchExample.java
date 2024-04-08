package src.com.company.week2.day3;

public class BinarySearchExample {

    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = r - l / 2;

            // 중간값이 찾는 값과 같은 경우
            if (arr[mid] == x)
                return mid;

            // 중간값이 찾는 값보다 큰 경우 왼쪽 탐색
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // 중간값이 찾는 값보다 작은 경우 오른쪽 탐색
            return binarySearch(arr, mid + 1, r, x);
        }

        // 찾는 값이 배열에 없는 경우
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchExample ob = new BinarySearchExample();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10; // 찾고자 하는 값
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println( x + "를 찾을 수 없습니다.");
        else
            System.out.println( x + "가 발견된 인덱스: " + result);
        //10가 별견된 인덱스: 3
    }

}

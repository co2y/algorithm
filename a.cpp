#include<stdio.h>
void myinsert(int* num, int len, int index, int target){
    if(index == len){
        num[index] = target;
    }
    else{
        for (int i=len+1; i>index; i--){
            num[i] = num[i-1];
        }
        num[index] = target;
    }
}

int bs(int* num, int len, int target){
    int left=1;
    int right=len;
    while(left <= right){
        int mid = left+(right-left) / 2;
        if (num[mid]==target) {
            return mid;
        }
        else{
            if (num[mid] < target){
                left = mid+1;
            }
            else{
                right = mid;
                if (left == right) {
                    break;
                }
            }
        }
    }
    return right;
}

int main(){
    int n;
    scanf("%d", &n);
    int number[300001];
    int i=0;
    int j=0;
    for (i=1; i<=n; ++i) {
        scanf("%d", &number[i]);
    }
    long long ans = 0;
    int snum[300001];
    int index;
    for (j=1; j<=n; j++){
        index = bs(snum, j, number[j]);
        ans = ans+index;
        myinsert(snum, j, index, number[j]);
    }
    printf("%lld\n", ans);
    return 0;
}

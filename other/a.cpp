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
    // if (len < 1) return 0;
    int left=0;
    int right=len-1;
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
    return left;
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
        index = bs(snum, j-1, number[j]);
        printf("%d\n", index);
        ans = ans+(j-1-index);
        // printf("%lld\n", ans);
        myinsert(snum, j, index, number[j]);
    }
    printf("%lld\n", ans);
    return 0;
}

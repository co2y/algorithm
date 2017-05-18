#include<cstdio>
#include<cstring>
int n;
int a[100001], tmp[100001];
long long tot=0;
void init() {
	scanf("%d", &n);
	for (int i=1;i<=n;i++) {
		scanf("%d", &a[i]);
	}
}
void ms(int l, int r) {
	if (l==r) return;
	int mid = (l+r) / 2;
	ms(l,mid); ms(mid+1,r);
	int i=l, p=l, j=mid+1;
	while (i<=mid && j<=r) {
		if (a[i]>a[j]) {
			tot+=mid-i+1;
			tmp[p++] = a[j++];
		} else tmp[p++] = a[i++];
	}
	while (i<=mid) tmp[p++] = a[i++];
	while (j<=r) tmp[p++] = a[j++];
	for (int i=l;i<=r;i++) a[i] = tmp[i];
}
void go() {
	ms(1,n);
	printf("%lld", tot);
}
int main() {
	init();
	go();
	return 0;
}

#include<iostream>
#include<map>
#include<algorithm>
#include<cstring>
using namespace std;
long long n,a[100010],b[100010],l,r;
map<long long,long long>s;
long long ans=0;
struct rec{
  long long l,r;
  long long num;
}tree[100010<<2];
void build(long long l,long long r,long long arrnum){
  if (l==r){
    tree[arrnum].l=tree[arrnum].r=l;
    tree[arrnum].num=0;
    return;
  }
  tree[arrnum].l=l,tree[arrnum].r=r;
  build(l,(l+r)>>1,arrnum<<1);
  build(((l+r)>>1)+1,r,(arrnum<<1)|1);
  tree[arrnum].num=0;
}
void ques(int arrnum){
  if (tree[arrnum].l>=l&&tree[arrnum].r<=r){
    ans+=tree[arrnum].num;
    return;
  }
  long long mid=(tree[arrnum].l+tree[arrnum].r)>>1;
  if (r<=mid) ques(arrnum<<1);
  else if (l>mid) ques((arrnum<<1)|1);
  else{
    ques(arrnum<<1);
    ques((arrnum<<1)|1);
  }
}
void ins(long long arrnum){
  if (tree[arrnum].l==tree[arrnum].r){
    tree[arrnum].num=1;
    return;
  }
  long long mid=(tree[arrnum].l+tree[arrnum].r)>>1;
  if (l<=mid) ins(arrnum<<1);
  else ins((arrnum<<1)|1);
  tree[arrnum].num=tree[arrnum<<1].num+tree[(arrnum<<1)|1].num;
}
int main(){
  ios::sync_with_stdio(false);
  cin>>n;
  for (long long i=1;i<=n;++i) cin>>a[i];
  memcpy(b,a,sizeof(a));
  sort(b+1,b+1+n);
  r=n;
  build(1,n,1);
  for (long long i=1;i<=n;++i) s.insert(make_pair(b[i],i));
  for (long long i=1;i<=n;++i){
    l=s.find(a[i])->second;
    ques(1);
    ins(1);
  }
  cout<<ans;
  return 0;
}

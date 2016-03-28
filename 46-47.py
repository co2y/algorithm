46:两种递归

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        res = []
        self.dfs(nums, [], res)
        return res

    def dfs(self, nums, path, res):
        if not nums:
            res.append(path)
            # return # backtracking
        for i in range(len(nums)):
            self.dfs(nums[:i]+nums[i+1:], path+[nums[i]], res)
            
           
#include<iostream>  
#include<vector>  
  
using namespace std;  
  
#define MAX 20  
  
vector<int>index;  
int visited[MAX]={0};  
  
void dfs(int arr[],int len,int num,int k)//len代表数组长度，num表示当前求到第几个，k表示多少数的全排列  
{  
    if(k==num){  
        for(int i=0;i<num;i++){  
            cout<<arr[index[i]]<<" ";  
        }  
        cout<<endl;  
        return;  
    }  
    for(int i=0;i<len;i++){  
        if(visited[i]==0){  
            index.push_back(i);  
            visited[i] = 1;  
            num++;  
            dfs(arr,len,num,k);  
            index.pop_back();  
            num--;  
            visited[i]=0;  
        }  
    }  
}  
  
int main()  
{  
    int arr[]={1,2,3,4};  
    dfs(arr,4,0,3);//求3个数的全排列  
    system("pause");  
    return 0;  
}  

            
47:利用31题得到next排列数

class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):  
        ans=[]
        num.sort();
        self.num=num[:]
        while(True):
            ans.append(self.num[:])
            if not self.nextPermutation():  break
        return ans
        
    def nextPermutation(self):
        j,k=len(self.num)-2,len(self.num)-1
        while j >= 0:
            if self.num[j] < self.num[j+1]: break
            j -= 1

        if j < 0:return False
        
        while k > j :
            if self.num[k] > self.num[j]:   break
            k -= 1
          
        self.num[j],self.num[k]=self.num[k],self.num[j]    
        self.num=self.num[:j+1]+self.num[:j:-1]
        return True
//
//  main.cpp
//  acmtest
//
//  Created by Mac on 16/4/6.
//  Copyright © 2016年 Mac. All rights reserved.
//

#include <iostream>

using namespace std;

int main() {
    
    int t;
    cin >> t;
    while (t--) {
        int n,w,h,p;
        cin >> n >> p >> w >> h;
        
        int ans;
        
        if (w>h){
            ans = h;
        }
        else {
            ans = w;
        }
        
        int a[n];
        
        for(int i=0; i<n; i++){
            cin >> a[i];
        }
        
        while (ans) {
            int line = 0;
            
            for (int i=0; i<n;i++){
                int oneline = w / ans;
                
                if (a[i] % oneline == 0){
                    line = line + a[i]/oneline;
                }
                else{
                    line = line + a[i]/oneline + 1;
                }
            }
            
            if (line <= (p * (h/ans))) break;
            ans--;
        }
        
        cout << ans << endl;
    }
    return 0;
}

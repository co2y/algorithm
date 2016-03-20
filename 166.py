class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        if denominator == 0:
            return None
        if numerator == 0:
            return "0"
        a = long(numerator)
        b = long(denominator)

        flag = "" if a*b > 0 else "-"

        a = abs(a)
        b = abs(b)

        c = a/b
        r = a%b

        if r == 0:
            return flag+str(c)

        s = "."

        r_dict = {}

        while r!=0:
            if r in r_dict:
                r_index = r_dict[r]
                ans = flag + str(c)
                ans += s[:r_index] + "(" + s[r_index:] + ")"
                return ans

            r_dict[r] = len(s)
            r = r * 10
            s += str(r/b)

            r = r%b

        return flag+str(c)+s

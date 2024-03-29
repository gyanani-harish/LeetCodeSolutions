# Remove K Digits
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a non-negative integer S&nbsp;represented as a string, remove&nbsp;K&nbsp;digits from the number so that the new number is the smallest possible.<br>
<strong>Note :&nbsp;</strong>The given&nbsp;<em>num</em>&nbsp;does not contain any leading zero.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input:</strong>
S = "149811", K = 3
<strong>Output:</strong> 111
<strong>Explanation</strong>: Remove the three digits 
4, 9, and 8 to form the new number 111
which is smallest.</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre style="position: relative;"><span style="font-size:18px"><strong>Input</strong>:
S = "1002991", K = 3
<strong>Output:</strong> 21
<strong>Explanation</strong>: Remove the three digits 1(leading
one), 9, and 9 to form the new number 21(Note
that the output must not contain leading
zeroes) which is the smallest.</span><div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>removeKdigits()&nbsp;</strong>which takes the string S and an integer K as input and returns the new number which is the smallest possible.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(|S|).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(|S|).</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1&lt;=|S|&lt;=10002</span><br>
<span style="font-size:18px">1&lt;=K&lt;=|S|</span></p>
</div>
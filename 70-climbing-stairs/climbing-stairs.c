int climbStairs(int n) {
	int i;
	int numb1;
	int numb2;
	i = 0;
	numb1 = 0;
	numb2 = 1;
	while(i != n)
	{
		if (i % 2 == 0)
			numb1 = numb1 + numb2;
		else
			numb2 = numb2 + numb1;
		i++;
	}
	if (i % 2 == 0)
			return numb2;
	return numb1;
}
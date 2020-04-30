j = (long)(raw_input())
k = (long)(raw_input())
size = [];
test = [];
result = 0
for c in range(j):
	t = (raw_input())
	if t == 'S':
			size.append(1)
	elif t == 'M':
			size.append(2)
	elif t == 'L':
			size.append(3)
for u in range(k):
	t = (raw_input().split())
	if t[0] == 'S':
			t[0] = 1
	if t[0] == 'M':
			t[0] = 2
	if t[0] == 'L':
			t[0] = 3
	test.append(t)
for q in range(k):
	 if int(test[q][1]) <= len(size) and size[int(test[q][1]) - 1] != -1:
		 if size[int(test[q][1]) - 1] <= test[q][0]:
				 result = result + 1
				 size[int(test[q][1]) - 1] = -1
print(result)

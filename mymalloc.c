// 

struct Node{								// size: 13 bytes
	int size; 								// number of chunks the node contains
	char used;								// smallest sized variable to see if it is used or not(0 for free 1 for used)
	Node *next;								// node pointer to the next linked list node
	Node *prev;								// node pointer to the previous linked list node
};

Node *first;
Node *last;

void *my_worstfit_malloc(int size)
{
	Node *current_node;
	Node *temp;
	void *point;
	int total_size;
	int temp_size;
	current_node = first;
	temp = NULL;
	while(current_node != NULL)
	{
		if(current_node->used == 0)
		{
			if(current_node->size > size && current_node->size >temp->size)
			{
				temp = current_node;
			}
		}
		current_node = current_node->next;
	}

	if(temp == NULL)
	{
		total_size = size +sizeof(Node);
		point = sbrk(total_size);
		new_node = point - total_size;			//set new node pointer equal to original brk pointer value
		if(first == NULL)						// if this is our first allocation, this becomes our first node
		{
			first = new_node;
		}

		new_node->prev = last_node;
		if(last_node != NULL)					//if this is our first allocation, we dont want to reset NULL
		{
			last_node->next = new_node;
		}
		last_node = new_node;					
		
		new_node ->size = size;
		new_node->free = 1;
		
		return point - size;
	}
	
	temp_size = temp->size - size;				// get size of the new free section
	temp->size = size;							// set size of new allocated section
	temp->used = 1;								// set allocation variable
	new_node = temp+size;						// set new node pointer to whats left after allocation
	new_node->size = temp_size;					// set free node pointer
	new_node->prev = temp;						// set free node previous to be our allocated node
	new_node->next = temp->next;				// set free node's next to be the old free node's next
	temp->next = new_node;						// set next of our allocated node to be our free node
	
	return new_node - size;						// return the pointer to location of the usable allocated space
}

my_free(void *ptr)
{
	Node *free_node;
	Node *temp;
	free_node = ptr -13;
	free_node->used = 0;
	temp = free_node->prev;
	if(temp->used == 0)
	{
		temp->size = free_node->size+temp->size+13;
		
	}
}

